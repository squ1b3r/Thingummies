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

import cpw.mods.fml.common.registry.GameRegistry

import net.minecraft.init.{Blocks, Items}
import net.minecraft.item.ItemStack
import net.minecraftforge.oredict.ShapedOreRecipe

import squ1b3r.thingummies.helper.ColorHelper

object BlockRecipes {

  def init(): Unit = {
    for (meta <- ColorHelper.COLORS.keys) {
      // Slick Block
      GameRegistry.addRecipe(new ShapedOreRecipe(
        new ItemStack(ModBlocks.slickBlock, 8, meta),
        "SQS", "QDQ", "SQS",
        'S': Character, Blocks.stone,
        'Q': Character, Items.quartz,
        'D': Character, ColorHelper.getDyeName(meta)
      ))

      // Shabby Block
      GameRegistry.addRecipe(new ShapedOreRecipe(
        new ItemStack(ModBlocks.shabbyBlock, 8, meta),
        "CQC", "QDQ", "CQC",
        'C': Character, Blocks.cobblestone,
        'Q': Character, Items.quartz,
        'D': Character, ColorHelper.getDyeName(meta)
      ))

      // Stained Block
      GameRegistry.addRecipe(new ShapedOreRecipe(
        new ItemStack(ModBlocks.stainedBlock, 8, meta),
        "SQS", "QDQ", "SQS",
        'S': Character, Blocks.sand,
        'Q': Character, Items.quartz,
        'D': Character, ColorHelper.getDyeName(meta)
      ))

      // Noisy Block
      GameRegistry.addRecipe(new ShapedOreRecipe(
        new ItemStack(ModBlocks.noisyBlock, 8, meta),
        "SQS", "QDQ", "SQS",
        'S': Character, Blocks.sand,
        'Q': Character, Blocks.stone,
        'D': Character, ColorHelper.getDyeName(meta)
      ))

      // Convenience Recipes
      GameRegistry.addShapelessRecipe(
        new ItemStack(ModBlocks.shabbyBlock, 1, meta),
        new ItemStack(ModBlocks.slickBlock, 1, meta)
      )
      GameRegistry.addShapelessRecipe(
        new ItemStack(ModBlocks.stainedBlock, 1, meta),
        new ItemStack(ModBlocks.shabbyBlock, 1, meta)
      )
      GameRegistry.addShapelessRecipe(
        new ItemStack(ModBlocks.noisyBlock, 1, meta),
        new ItemStack(ModBlocks.stainedBlock, 1, meta)
      )
      GameRegistry.addShapelessRecipe(
        new ItemStack(ModBlocks.slickBlock, 1, meta),
        new ItemStack(ModBlocks.noisyBlock, 1, meta)
      )
    }
  }
}
