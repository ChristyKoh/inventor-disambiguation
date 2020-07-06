/* Copyright (C) 2016 University of Massachusetts Amherst.
   This file is part of “inventor_disambiguation”

   This work was done for the USPTO inventor disambiguation workshop
   organized under the PatentsView initiative (www.patentsview.org).
   The algorithm was the best performing at the workshop according
   to the workshop judges' criteria of disambiguation performance,
   running time, and usability.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
    http://www.apache.org/licenses/LICENSE-2.0
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License. */


package edu.umass.cs.iesl.inventor_disambiguation.load

import edu.umass.cs.iesl.inventor_disambiguation._
import edu.umass.cs.iesl.inventor_disambiguation.data_structures.Patent

object LoadPatent extends TabSeparatedFileLoader[Patent]{
  override def parse(split: Array[String]): Option[Patent] = {
    val id = split(0).trimQuotesBegEnd()
    val typ = split(1).trimQuotesBegEnd()
    val number = split(2).trimQuotesBegEnd()
    val country = split(3).trimQuotesBegEnd()
    val date = split(4).trimQuotesBegEnd()
    val abstr = split(5).trimQuotesBegEnd()
    val title = split(6).trimQuotesBegEnd()
    val kind = split(7).trimQuotesBegEnd()
    val numClaims = split(8).trimQuotesBegEnd()
    val filename = split(9).trimQuotesBegEnd()
    val withdrawn = split(10).trimQuotesBegEnd()
    Some(new Patent(id, typ, number, country, date, abstr, title, kind, numClaims, filename))
  }

  override def skipFirstLine: Boolean = true

  override def expectedLineLengths: Set[Int] = Set(11)
}
