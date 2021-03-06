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
package squ1b3r.thingummies.items

import cpw.mods.fml.common.registry.GameRegistry

import net.minecraft.item.ItemStack
import net.minecraftforge.oredict.ShapedOreRecipe

import squ1b3r.thingummies.integration.CoFH.RedstoneArsenalItems
import squ1b3r.thingummies.items.tool.ItemMagnetRF

object ItemRecipes {

  def init() {
    // Magnet
    if (ItemConfig.ItemMagnetEnable) {
      GameRegistry.addRecipe(new ShapedOreRecipe(
        new ItemStack(ItemMagnetRF),
        "RIR", "I I", "RIR",
        'R': Character, RedstoneArsenalItems.rodObsidianFlux,
        'I': Character, "ingotElectrumFlux"
      ))
    }
  }
}
