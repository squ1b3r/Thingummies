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
package squ1b3r.thingummies.blocks

import java.util.{List => JList}

import cpw.mods.fml.relauncher.{Side, SideOnly}

import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.{Item, ItemStack}
import net.minecraft.util.IIcon
import net.minecraft.world.IBlockAccess

import squ1b3r.thingummies.helper.ColorHelper
import squ1b3r.thingummies.reference.Reference

class BlockFactory(name: String) extends Block(Material.rock) {

  setBlockName(Reference.ModID + "." + name)
  setHardness(3.0F)
  setResistance(4.0F)

  var blockIconWhite: IIcon = null
  var blockIconBlack: IIcon = null

  @SideOnly(Side.CLIENT)
  override def getRenderColor(meta: Int): Int = meta match {
    case 0 | 15 => 16777215
    case _ => ColorHelper.getColor(meta)
  }

  @SideOnly(Side.CLIENT)
  override def colorMultiplier(world: IBlockAccess, x: Int, y: Int, z: Int): Int = {
    getRenderColor(world.getBlockMetadata(x, y, z))
  }

  @SideOnly(Side.CLIENT)
  override def getSubBlocks(item: Item, par2CreativeTabs: CreativeTabs, stacks: JList[_]) = {
    ColorHelper.COLORS.keys foreach (meta => stacks.asInstanceOf[JList[ItemStack]].add(new ItemStack(item, 1, meta)))
  }

  @SideOnly(Side.CLIENT)
  override def registerBlockIcons(iconRegister: IIconRegister): Unit = {
    blockIcon = iconRegister.registerIcon(getBlockIconName("colored"))
    blockIconWhite = iconRegister.registerIcon(getBlockIconName("white"))
    blockIconBlack = iconRegister.registerIcon(getBlockIconName("black"))
  }

  @SideOnly(Side.CLIENT)
  override def getIcon(side: Int, meta: Int): IIcon = meta match {
    case 0 => blockIconWhite
    case 15 => blockIconBlack
    case _ => blockIcon
  }

  override def getUnlocalizedName: String = super.getUnlocalizedName

  override def damageDropped(meta: Int) = meta

  def getBlockIconName(postfix: String): String = Reference.ModID + ":" + name + "." + postfix
}


