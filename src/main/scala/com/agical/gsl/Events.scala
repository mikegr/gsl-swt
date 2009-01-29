/*
 * The file is licenced under Revision 42 of the Beerware Licence.
 * <joakim.ohlrogge[at]agical.com> wrote this file. As long as you retain this
 * notice you can do whatever you want with this stuff. If we meet some day,
 * and you think this stuff is worth it, you can buy me a beer in return.
 * -- Joakim Ohlrogge.
 */

package com.agical.gsl

import org.eclipse.swt.events.{SelectionAdapter, SelectionListener, SelectionEvent}

trait Events {
    def onSelect[T <: {def addSelectionListener(l:SelectionListener)}](handler:(GSL,SelectionEvent) => Unit)(gsl:GSL, subject:T) = {
        subject.addSelectionListener(
            new SelectionAdapter {
                override def widgetSelected(e:SelectionEvent) = {
                    handler(gsl, e)
                }
            }
        )
    }
}
