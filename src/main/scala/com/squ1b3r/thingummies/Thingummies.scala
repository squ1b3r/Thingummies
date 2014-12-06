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
package com.squ1b3r.thingummies

import java.io.File

import com.squ1b3r.thingummies.handler.{ConfigurationHandler, RegistryHandler}
import com.squ1b3r.thingummies.item.ItemRecipes
import com.squ1b3r.thingummies.reference.{LoaderStatus, Reference}
import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.Mod.EventHandler
import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPreInitializationEvent}
import net.minecraftforge.common.config.Configuration

@Mod(name = Reference.Name, modid = Reference.ModID, version = Reference.Version, dependencies = Reference.Dependencies, modLanguage = "scala")
object Thingummies {

  /**
   * FML preInit
   *
   * Loads configuration
   *
   * @param event FML event
   */
  @EventHandler
  def preInit(event: FMLPreInitializationEvent): Unit = {
    ConfigurationHandler.loadConfiguration(
      new Configuration(new File(event.getModConfigurationDirectory, Reference.ModID + "/main.cfg"))
    )

    // Tools
    RegistryHandler.registerTools()
  }

  /**
   * FML Init
   *
   * Registers blocks/items
   *
   * @param event FML event
   */
  @EventHandler
  def init(event: FMLInitializationEvent): Unit = {
    // Recipes
    if (LoaderStatus.RedstoneArsenalLoaded)
      ItemRecipes.init()
  }
}
