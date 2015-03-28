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
package squ1b3r.thingummies.integration.Chisel

import com.cricketcraft.chisel.api.IMC
import cpw.mods.fml.common.Optional

import cpw.mods.fml.common.event.FMLInterModComms

import squ1b3r.thingummies.blocks.ModBlocks
import squ1b3r.thingummies.blocks.BlockFactory
import squ1b3r.thingummies.helper.ColorHelper
import squ1b3r.thingummies.reference.Reference

@Optional.Interface(modid = Reference.dependentMods.ChiselID, iface = "com.cricketcraft.chisel.api.IMC")
object ThingummiesChisel {

  def registerBlocks(): Unit = {
    registerChiselBlock(ModBlocks.slickBlock)
    registerChiselBlock(ModBlocks.stainedBlock)
    registerChiselBlock(ModBlocks.shabbyBlock)
    registerChiselBlock(ModBlocks.noisyBlock)
  }

  def registerChiselBlock(block: BlockFactory): Unit = {
    for (meta <- ColorHelper.COLORS.keys) {
      FMLInterModComms.sendMessage(IMC.CHISEL_MODID, IMC.ADD_VARIATION.key, getChiselVariationString(block, meta))
    }
  }

  def getChiselVariationString(block: BlockFactory, meta: Int): String = {
    block.getName + "|" + block.getName + "|" + meta
  }
}
