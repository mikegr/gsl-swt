/*
 * The file is licenced under Revision 42 of the Beerware Licence.
 * <joakim.ohlrogge[at]agical.com> wrote this file. As long as you retain this
 * notice you can do whatever you want with this stuff. If we meet some day,
 * and you think this stuff is worth it, you can buy me a beer in return.
 * -- Joakim Ohlrogge
 */

package com.agical.gsl

import org.eclipse.swt.widgets.Tree

case class present (state:(Tree, (Tree) => Unit) => Unit) {
    def using(present:Tree => Unit)(gsl:GSL, target:Tree) = {
        gsl.addObserver(() => state(target, present))
        state(target, present)
    }
}