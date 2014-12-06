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
package com.squ1b3r.thingummies.handler

import com.squ1b3r.thingummies.item.tool.ItemMagnetRF
import com.squ1b3r.thingummies.reference.Reference
import cpw.mods.fml.common.registry.GameRegistry

@GameRegistry.ObjectHolder(Reference.ModID)
object RegistryHandler {

  def registerTools(): Unit = {
    // Tools
    GameRegistry.registerItem(ItemMagnetRF, ItemMagnetRF.getUnlocalizedName)
  }
}
