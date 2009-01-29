/*
 * The file is licenced under Revision 42 of the Beerware Licence.
 * <joakim.ohlrogge[at]agical.com> wrote this file. As long as you retain this
 * notice you can do whatever you want with this stuff. If we meet some day,
 * and you think this stuff is worth it, you can buy me a beer in return.
 * -- Joakim Ohlrogge
 */

package com.agical.gsl

import com.agical.gsl.Swt._

import org.eclipse.swt.SWT
import org.eclipse.swt.events.SelectionEvent
import org.eclipse.swt.widgets._

object Main {
    def main(args:Array[String]) = {
       val controller = shell(
            text("caption"),
            rowLayout(),
            label(
                text("hello world")
            )
        )
        controller()
    }
}

object HandlingEvents {
    def main(args:Array[String]) = {
        var theText = (x:String) => {println("clicked")}
        var theLabel:Option[Label] = None

        implicit def toSome[T](value:T) = Some(value)
        implicit def keep[T](setter:Option[T]=>Unit)(widget:T) = setter(Some(widget))

        val theShell = shell(
            text("caption"),
            rowLayout(),
            button(
                text("Press me!"),
                onSelect((gsl:GSL, e:SelectionEvent) => {theText("button pressed")})
            ),
            label(
                text("Button not pressed")
            )
        )
        theShell()
    }
}

object MoreAdvancedMain {
    def main(args:Array[String]) = {
        val controller = shell(
            text("User Profile"),
            composite (
                gridLayout(columns(2)),
                group (
                    text("Name"),
                    gridLayout(columns(2)),
                    horizontal(
                        fill,
                        grabExcessSpace
                    ),
                    vertical(
                        fill,
                        grabExcessSpace
                    ),
                    label(text("First")), edit(text("Bullet")),
                    label(text("Last")),  edit(text("Tooth"))
                ),
                group (
                    rowLayout(),
                    horizontal(
                        fill,
                        grabExcessSpace
                    ),
                    vertical(
                        fill,
                        grabExcessSpace
                    ),
                    text("Gender"),
                    radioButton (text ("Male"), selected),
                    radioButton (text ("Female"))
                ),
                group (
                    rowLayout(),
                    horizontal(
                        fill,
                        grabExcessSpace
                    ),
                    vertical(
                        fill,
                        grabExcessSpace
                    ),
                    text("Role"),
                    checkBox (text("Student"), selected),
                    checkBox (text("Employee"), selected)
                ),
                group (
                    text("Experience"),
                    rowLayout(),
                    horizontal(
                        fill,
                        grabExcessSpace
                    ),
                    vertical(
                        fill,
                        grabExcessSpace
                    ),
                    spinner(selectedIndex(5)), label {text ("years")}
                ),
                button (
                    text("save"),
                    horizontal(
                        fill,
                        grabExcessSpace
                    ),
                    vertical(
                        fill,
                        grabExcessSpace
                    ),
                ),
                button (
                    text("close"),
                    horizontal(
                        fill,
                        grabExcessSpace
                    ),
                    vertical(
                        fill,
                        grabExcessSpace
                    ),
                )
           )
        )
        controller()
    }
}
