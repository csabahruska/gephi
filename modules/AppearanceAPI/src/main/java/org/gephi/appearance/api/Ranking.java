/*
 Copyright 2008-2013 Gephi
 Authors : Mathieu Bastian <mathieu.bastian@gephi.org>
 Website : http://www.gephi.org

 This file is part of Gephi.

 DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.

 Copyright 2013 Gephi Consortium. All rights reserved.

 The contents of this file are subject to the terms of either the GNU
 General Public License Version 3 only ("GPL") or the Common
 Development and Distribution License("CDDL") (collectively, the
 "License"). You may not use this file except in compliance with the
 License. You can obtain a copy of the License at
 http://gephi.org/about/legal/license-notice/
 or /cddl-1.0.txt and /gpl-3.0.txt. See the License for the
 specific language governing permissions and limitations under the
 License.  When distributing the software, include this License Header
 Notice in each file and include the License files at
 /cddl-1.0.txt and /gpl-3.0.txt. If applicable, add the following below the
 License Header, with the fields enclosed by brackets [] replaced by
 your own identifying information:
 "Portions Copyrighted [year] [name of copyright owner]"

 If you wish your version of this file to be governed by only the CDDL
 or only the GPL Version 3, indicate your decision by adding
 "[Contributor] elects to include this software in this distribution
 under the [CDDL or GPL Version 3] license." If you do not indicate a
 single choice of license, a recipient has the option to distribute
 your version of this file under either the CDDL, the GPL Version 3 or
 to extend the choice of license to its licensees as provided above.
 However, if you add GPL Version 3 code and therefore, elected the GPL
 Version 3 license, then the option applies only if the new code is
 made subject to such option by the copyright holder.

 Contributor(s):

 Portions Copyrighted 2013 Gephi Consortium.
 */

package org.gephi.appearance.api;

import org.gephi.graph.api.Element;
import org.gephi.graph.api.Graph;

/**
 * Ranking configuration for numerical attributes.
 * <p>
 * This interface has underlying access to the elements value so it can return
 * the minimum and maximum values.
 */
public interface Ranking {

    /**
     * Returns the minimum value in this ranking.
     *
     * @param graph   graph to query
     * @return minimum value
     */
    Number getMinValue(Graph graph);

    /**
     * Returns the maximum value in this ranking.
     *
     * @param graph   graph to query
     * @return maximum value
     */
    Number getMaxValue(Graph graph);

    /**
     * Returns the element's value for this ranking.
     *
     * @param element element to get the value for
     * @param graph   graph this element belongs to
     * @return the value for this ranking
     */
    Number getValue(Element element, Graph graph);

    /**
     * Returns the element's normalized value for this ranking.
     *
     * @param element element to get the value for
     * @param graph   graph this element belongs to
     * @return the normalized value for this ranking
     */
    float getNormalizedValue(Element element, Graph graph);

    /**
     * Normalizes the given value with the interpolator.
     * <p>
     * The value is first put between zero and one by doing <code>(value - min) / (max
     * - min)</code> and then passed to the given interpolator.
     *
     * @param value        value to normalize
     * @param interpolator interpolator
     * @return normalized value
     */
    float normalize(Number value, Interpolator interpolator, Number minValue, Number maxValue);
}
