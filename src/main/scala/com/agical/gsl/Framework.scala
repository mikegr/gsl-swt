/*
 * The file is licenced under Revision 42 of the Beerware Licence.
 * <joakim.ohlrogge[at]agical.com> wrote this file. As long as you retain this
 * notice you can do whatever you want with this stuff. If we meet some day,
 * and you think this stuff is worth it, you can buy me a beer in return.
 * -- Joakim Ohlrogge.
 */

package com.agical.gsl

import org.eclipse.swt.widgets.{Composite, Widget}

object Framework {

    def createWidget[T](factory:Composite => T)(setups:(GSL, T) => Unit*)(gsl:GSL, parent:Composite) = {
        performSetup(factory(parent), setups.map(x => (x(gsl,_:T))))
    }

    def performSetup[T](target:T, setups:Seq[(T) => Unit]) = {
        setups.foreach(setup => setup(target))
    }
}
