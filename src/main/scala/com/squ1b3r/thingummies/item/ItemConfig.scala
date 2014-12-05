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
package com.squ1b3r.thingummies.item

import net.minecraft.item.Item

import net.minecraftforge.common.config.Configuration
import net.minecraftforge.common.util.EnumHelper

import com.squ1b3r.thingummies.reference.Reference

object ItemConfig {

  object categories {
    final val Crafting: String = "Crafting"
  }

  final val ToolMaterial: Item.ToolMaterial = EnumHelper.addToolMaterial("RA_FLUX", 3, 100, 8.0F, 0.0F, 25)
  final val ToolTexturePath: String = Reference.ModID + ":tool/Flux"

  // Flux-Infused Magnet
  var ItemMagnetEnable: Boolean = true
  final val ItemMagnetName: String = "Flux-Infused Magnet"
  final val ItemMagnetUnlocalizedName = Reference.ModID + ".tool.FluxMagnet"

  def update(configuration: Configuration): Unit = {
    // Crafting Settings
    ItemMagnetEnable = configuration.get(categories.Crafting, ItemMagnetName, ItemMagnetEnable).getBoolean(ItemMagnetEnable)
  }
}
