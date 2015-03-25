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
package squ1b3r.thingummies.helper

import cpw.mods.fml.common.FMLLog

import org.apache.logging.log4j.Level

import squ1b3r.thingummies.reference.Reference

object LogHelper {

  def log(logLevel: Level, data: Any): Unit = FMLLog.log(Reference.ModID, logLevel, data.toString)

  def error(data: Any): Unit = log(Level.ERROR, data)

  def warning(data: Any): Unit = log(Level.WARN, data)

  def info(data: Any): Unit = log(Level.INFO, data)

}
