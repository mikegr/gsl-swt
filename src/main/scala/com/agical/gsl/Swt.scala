/*
 * The file is licenced under Revision 42 of the Beerware Licence.
 * <joakim.ohlrogge[at]agical.com> wrote this file. As long as you retain this
 * notice you can do whatever you want with this stuff. If we meet some day,
 * and you think this stuff is worth it, you can buy me a beer in return.
 * -- Joakim Ohlrogge
 */

package com.agical.gsl

import org.eclipse.swt.{SWT}
import org.eclipse.swt.widgets._
import org.eclipse.swt.layout.{RowLayout, FillLayout}

class Controller(shell:Shell) {
    def apply() {
        shell.pack();
        shell.open();
        val display = shell.getDisplay
        while( !shell.isDisposed())
        {

            if(!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }
}


object Swt extends Layouts 
           with Buttons
           with Labels
           with Inputs
           with Composites
           with Events
    {

    def shell(setups : ((GSL, Shell) => Unit)*) = {
        val display = new Display();
        val shell = new Shell(display);

        shell.setLayout(new FillLayout)
        val gsl = new GSL()
        setups.foreach(setup =>{setup(gsl, shell)})
        new Controller(shell)
    }

    def text[T <: {def setText(txt:String)}](txt:String)(gsl:GSL, subject:T) = {
        subject.setText(txt)
    }

    def text[T <: {def setText(txt:String)}](txt:(() => String))(gsl:GSL, subject:T) = {
        subject.setText(txt())
    }

    def selected[T <: {def setSelection(s:Boolean)}](gsl:GSL, subject:T) = {
        subject.setSelection(true)
    }

    def selectedIndex[T <: {def setSelection(s:Int)}](source:Int)(gsl:GSL, target:T) {
        target.setSelection(source)
    }

    def selection[T <: {def setSelection(s:Int)}](target:T, source:Int) = {
        target.setSelection(source)
    }

    def maximum [T <: {def setMaximum(m:Int)}](target:T, source:Int) = {
        target.setMaximum(source)
    }

    def enabled [T <: {def setEnabled(m:Boolean)}](target:T, source:Boolean) = {
        target.setEnabled(source)
    }

    def items(target:Tree, presenter:Tree => Unit):Unit = presenter(target)
}
