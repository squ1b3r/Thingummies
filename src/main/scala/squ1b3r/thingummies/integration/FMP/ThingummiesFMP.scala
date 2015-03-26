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
package squ1b3r.thingummies.integration.FMP

import codechicken.microblock.{BlockMicroMaterial, MicroMaterialRegistry}

import net.minecraft.block.Block

import squ1b3r.thingummies.blocks.ModBlocks
import squ1b3r.thingummies.helper.ColorHelper

object ThingummiesFMP {

  def registerBlocks(): Unit = {
    registerColorBlock(ModBlocks.slickBlock)
    registerColorBlock(ModBlocks.stainedBlock)
    registerColorBlock(ModBlocks.shabbyBlock)
    registerColorBlock(ModBlocks.noisyBlock)
  }

  def registerColorBlock(block: Block): Unit = {
    for (meta <- ColorHelper.COLORS.keys) {
      MicroMaterialRegistry.registerMaterial(new ColoredMicroMaterial(block, meta), getMaterialKey(block, meta))
    }
  }

  def getMaterialKey(block: Block, meta: Int): String = BlockMicroMaterial.materialKey(block, meta)
}
