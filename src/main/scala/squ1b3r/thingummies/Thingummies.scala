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
package squ1b3r.thingummies

import cpw.mods.fml.common.{SidedProxy, Mod}
import cpw.mods.fml.common.Mod.EventHandler
import cpw.mods.fml.common.event.{FMLPostInitializationEvent, FMLInitializationEvent, FMLPreInitializationEvent}

import squ1b3r.thingummies.proxy.CommonProxy
import squ1b3r.thingummies.reference.Reference

@Mod(name = Reference.Name, modid = Reference.ModID, version = Reference.Version, dependencies = Reference.Dependencies, modLanguage = "scala")
object Thingummies {

  val instance = this

  @SidedProxy(clientSide = "squ1b3r.thingummies.proxy.ClientProxy", serverSide = "squ1b3r.thingummies.proxy.ServerProxy")
  var proxy: CommonProxy = _

  /**
   * FML preInit
   *
   * @param event FML event
   */
  @EventHandler
  def preInit(event: FMLPreInitializationEvent): Unit = proxy.preInit(event)

  /**
   * FML Init
   *
   * @param event FML event
   */
  @EventHandler
  def init(event: FMLInitializationEvent): Unit = proxy.init(event)

  /**
   * FML postInit
   *
   * @param event FML event
   */
  @EventHandler
  def postInit(event: FMLPostInitializationEvent): Unit = proxy.postInit(event)

}
