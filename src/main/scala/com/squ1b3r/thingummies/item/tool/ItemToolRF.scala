/*
 * Copyright 2014 Andrey Kutyrev
 *
 * Licensed under the the GNU Public License v3.0;
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.gnu.org/licenses/gpl.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ========================================================================
 */
package com.squ1b3r.thingummies.item.tool

import java.util

import cpw.mods.fml.common.Optional
import cpw.mods.fml.relauncher.{Side, SideOnly}

import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.{Item, ItemStack}
import net.minecraft.util.IIcon

import cofh.api.energy.IEnergyContainerItem

import com.squ1b3r.thingummies.helper.{NBTHelper, StringHelper}

@Optional.Interface(modid="CoFHCore", iface = "cofh.api.energy.IEnergyContainerItem")
trait ItemToolRF extends Item with IEnergyContainerItem {

  setMaxStackSize(1)
  setNoRepair()

  protected val maxEnergy: Int = 160000
	protected val maxTransfer: Int = 1600
	protected val energyPerUse: Int = 80

  var itemActiveIcon: IIcon = null
  var itemDrainedIcon: IIcon = null

  protected val allowedEnchantments: List[Int] = List()

  // Item
  @SideOnly(Side.CLIENT)
  override def addInformation(stack: ItemStack, player: EntityPlayer, list: java.util.List[_], advanced: Boolean): Unit = {
    val tooltip: util.List[String] = list.asInstanceOf[util.List[String]]

    val storedEnergy = StringHelper.getFormattedNumber(NBTHelper.readIntegerFromNBT(stack, "Energy"))
		tooltip.add(StringHelper.Orange + StringHelper.LightGray + storedEnergy + " / " + StringHelper.getFormattedNumber(maxEnergy) + " RF")

    if (!StringHelper.isShiftKeyDown)
			tooltip.add(StringHelper.ShiftForInfo)

    if (!StringHelper.isShiftKeyDown)
      return

    updateInformation(stack, player, tooltip)
  }

  protected def updateInformation(stack: ItemStack, player: EntityPlayer, tooltip: util.List[String]): Unit = {}

  @SideOnly(Side.CLIENT)
	override def getSubItems(item: Item, tab: CreativeTabs, list: util.List[_]): Unit = {
    list.asInstanceOf[util.List[ItemStack]].add(NBTHelper.writeToNBT(new ItemStack(item, 1, 0), "Energy", 0))
    list.asInstanceOf[util.List[ItemStack]].add(NBTHelper.writeToNBT(new ItemStack(item, 1, 0), "Energy", maxEnergy))
	}

  override def getIconIndex(stack: ItemStack): IIcon = getIcon(stack, 0)

  override def getIcon(stack: ItemStack, pass: Int): IIcon = if (getEnergyStored(stack) <= 0) itemDrainedIcon else itemActiveIcon

  override def getDisplayDamage(stack: ItemStack): Int = 1 + maxEnergy - NBTHelper.readIntegerFromNBT(stack, "Energy")

  override def getMaxDamage(stack: ItemStack): Int = maxEnergy + 1

  override def isDamaged(stack: ItemStack): Boolean = stack.getItemDamage != java.lang.Short.MAX_VALUE

  // IEnergyContainerItem
  override def receiveEnergy(container: ItemStack, maxReceive: Int, simulate: Boolean): Int = {
		if (container.stackTagCompound == null) {
			NBTHelper.writeToNBT(container, "Energy", 0)
		}
		var stored: Int = NBTHelper.readIntegerFromNBT(container, "Energy")
	  var receive: Int = Math.min(maxReceive, Math.min(maxEnergy - stored, maxTransfer))

		if (!simulate) {
			stored += receive
			NBTHelper.writeToNBT(container, "Energy", stored)
		}
		receive
	}

	override def extractEnergy(container: ItemStack, maxExtract: Int, simulate: Boolean): Int = {
		if (container.stackTagCompound == null) {
			NBTHelper.writeToNBT(container, "Energy", 0)
		}
		var stored: Int = NBTHelper.readIntegerFromNBT(container, "Energy")
		var extract: Int = Math.min(maxExtract, stored)

		if (!simulate) {
			stored -= extract
      NBTHelper.writeToNBT(container, "Energy", stored)
		}
		extract
	}

	override def getEnergyStored(container: ItemStack): Int = {
		if (!NBTHelper.verifyNBTKey(container, "Energy")) {
			NBTHelper.writeToNBT(container, "Energy", 0)
		}
    NBTHelper.readIntegerFromNBT(container, "Energy")
	}

	override def getMaxEnergyStored(container: ItemStack): Int = maxEnergy

  override def isBookEnchantable(stack: ItemStack, book: ItemStack): Boolean = false
}