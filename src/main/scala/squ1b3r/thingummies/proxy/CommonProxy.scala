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
package squ1b3r.thingummies.proxy

import java.io.File

import cpw.mods.fml.common.Loader
import cpw.mods.fml.common.Mod.EventHandler
import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPreInitializationEvent, FMLPostInitializationEvent}

import net.minecraftforge.common.config.Configuration

import squ1b3r.thingummies.blocks.{BlockRecipes, ModBlocks}
import squ1b3r.thingummies.handler.ConfigurationHandler
import squ1b3r.thingummies.integration.Chisel.ThingummiesChisel
import squ1b3r.thingummies.integration.FMP.ThingummiesFMP
import squ1b3r.thingummies.items.{ItemRecipes, ModItems}
import squ1b3r.thingummies.reference.Reference

class CommonProxy {

  /**
   * FML preInit
   *
   * @param event FML event
   */
  @EventHandler
  def preInit(event: FMLPreInitializationEvent): Unit = {
    ConfigurationHandler.loadConfiguration(
      new Configuration(new File(event.getModConfigurationDirectory, Reference.ModID + "/main.cfg"))
    )

    ModBlocks.preInit()

    ModItems.preInit()
  }

  /**
   * FML Init
   *
   * @param event FML event
   */
  @EventHandler
  def init(event: FMLInitializationEvent): Unit = {
    // Recipes
    BlockRecipes.init()

    if (Loader.isModLoaded(Reference.dependentMods.RedstoneArsenalID))
      ItemRecipes.init()

    if (Loader.isModLoaded(Reference.dependentMods.ForgeMultipartID))
      ThingummiesFMP.registerBlocks()

    if (Loader.isModLoaded(Reference.dependentMods.ChiselID))
      ThingummiesChisel.registerBlocks()
  }

  /**
   * FML postInit
   *
   * @param event FML event
   */
  @EventHandler
  def postInit(event: FMLPostInitializationEvent): Unit = {}
}
