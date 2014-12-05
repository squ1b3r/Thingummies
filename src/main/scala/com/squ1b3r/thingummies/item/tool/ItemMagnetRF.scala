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
import scala.collection.convert.WrapAsScala._

import cpw.mods.fml.relauncher.{Side, SideOnly}

import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.Entity
import net.minecraft.entity.item.{EntityItem, EntityXPOrb}
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.{EnumRarity, ItemStack}
import net.minecraft.util.IIcon
import net.minecraft.world.World

import com.squ1b3r.thingummies.helper.{NBTHelper, StringHelper}
import com.squ1b3r.thingummies.item.ItemConfig
import com.squ1b3r.thingummies.reference.Sounds

object ItemMagnetRF extends ItemToolRF {

  private final val onUpdateCooldown: Int = 10
  private var tickCounter: Int = 0

  private final val radius: Int = 8

  private final val ON: Boolean = true

  setCreativeTab(CreativeTabs.tabTools)
  setUnlocalizedName(ItemConfig.ItemMagnetUnlocalizedName)
  setTextureName(ItemConfig.ToolTexturePath + "Magnet")

  @SideOnly(Side.CLIENT)
  override def getRarity(stack: ItemStack) = EnumRarity.uncommon

  @SideOnly(Side.CLIENT)
  override def updateInformation(stack: ItemStack, player: EntityPlayer, tooltip: util.List[String]) = {
    super.updateInformation(stack, player, tooltip)

    // TODO: Localization
    tooltip.add(StringHelper.Orange + "Energy Usage: " + StringHelper.BrightGreen + energyPerUse + StringHelper.LightGray + " RF Per Item")
    tooltip.add(StringHelper.Orange + "Radius: " + StringHelper.BrightGreen + radius + StringHelper.LightGray + " Blocks")
    tooltip.add("")
    tooltip.add(getToolState(stack))
  }

  @SideOnly(Side.CLIENT)
  override def registerIcons(iconRegister: IIconRegister): Unit = {
    itemIcon = iconRegister.registerIcon(getIconString)
    itemActiveIcon = iconRegister.registerIcon(getIconString)
    itemDrainedIcon = iconRegister.registerIcon(getIconString + "_Drained")
  }

  @SideOnly(Side.CLIENT)
  override def getIcon(stack: ItemStack, pass: Int): IIcon = isActive(stack) match {
    case ON => itemActiveIcon
    case _ => itemDrainedIcon
  }

  override def onItemRightClick(stack: ItemStack, world: World, player: EntityPlayer): ItemStack = {
    if (!world.isRemote && getEnergyStored(stack) >= energyPerUse) {
      toggleToolMode(stack)
    }
		super.onItemRightClick(stack, world, player)
	}

  private def toggleToolMode(stack: ItemStack): Unit = NBTHelper.writeToNBT(stack, "Active", !isActive(stack))

  private def isActive(stack: ItemStack): Boolean = getEnergyStored(stack) match {
    case energy if energy > 0 => NBTHelper.readBooleanFromNBT(stack, "Active")
    case _ => false
  }

  private def getToolState(stack: ItemStack): String = isActive(stack) match {
    // TODO: Localization
    case ON =>
      StringHelper.Orange + "Active: " + StringHelper.BrightGreen + "yes"
    case _ =>
      StringHelper.Orange + "Active: " + StringHelper.LightRed + "no"
  }

  override def onUpdate(stack: ItemStack, world: World, entity: Entity, slot: Int, selected: Boolean): Unit = {
    if (!world.isRemote) {

      tickCounter match {
        case `onUpdateCooldown` =>
          val player = entity.asInstanceOf[EntityPlayer]
          val bounds = player.boundingBox.expand(radius, radius, radius)

          // Collect available items
          if (isActive(stack) == ON && getEnergyStored(stack) >= energyPerUse) {
            val items = world.getEntitiesWithinAABB(classOf[EntityItem], bounds).map(_.asInstanceOf[EntityItem])
            for (item <- items) {
              if (!item.getEntityItem.isItemEqual(stack)) {
                val success: Boolean = player.inventory.addItemStackToInventory(item.getEntityItem)

                if (success) {
                  world.playSoundAtEntity(entity, Sounds.RandomPop, 0.2F, world.rand.nextFloat * 0.4F + 0.8F)

                  if (!player.capabilities.isCreativeMode) extractEnergy(stack, energyPerUse, false)
                }
              }
            }
          }

          // Collect available XP orbs
          if (isActive(stack) == ON && getEnergyStored(stack) >= energyPerUse) {
            val expOrbs = world.getEntitiesWithinAABB(classOf[EntityXPOrb], bounds).map(_.asInstanceOf[EntityXPOrb])
            if (expOrbs.length > 0) {
              for (orb <- expOrbs) {
                player.addExperience(orb.getXpValue)
                orb.setDead()
                if (!player.capabilities.isCreativeMode) extractEnergy(stack, energyPerUse, false)
              }
              world.playSoundAtEntity(entity, Sounds.RandomOrb, 0.1F, 0.5F * ((world.rand.nextFloat - world.rand.nextFloat) * 0.7F + 1.8F))
            }
          }
          tickCounter = 0
        case _ =>
          tickCounter += 1
      }
    }
  }
}


