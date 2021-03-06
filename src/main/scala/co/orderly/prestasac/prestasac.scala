/*
 * Copyright (c) 2012 Orderly Ltd. All rights reserved.
 *
 * This program is licensed to you under the Apache License Version 2.0,
 * and you may not use this file except in compliance with the Apache License Version 2.0.
 * You may obtain a copy of the Apache License Version 2.0 at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the Apache License Version 2.0 is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Apache License Version 2.0 for the specific language governing permissions and limitations there under.
 */
package co.orderly

// Narcolepsy
import co.orderly.narcolepsy.RestfulError

// Prestasac
import prestasac.representations.PrestaShopError

/**
 * Provides a Scala client for interacting with the PrestaShop Web Service, built on Narcolepsy:
 * http;//github.com/orderly/narcolepsy-scala
 */
package object prestasac {

  implicit def restfulError2Throwable(error: RestfulError[PrestaShopError]): Throwable = new Throwable(
    "HTTP status code: %s\nError messages:\n%s".format(
      error.statusCode,
      error.marshalledError.errors.map(r => r.message).mkString("\n"))
  )
}
