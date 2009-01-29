/*
 * The file is licenced under Revision 42 of the Beerware Licence.
 * <joakim.ohlrogge[at]agical.com> wrote this file. As long as you retain this
 * notice you can do whatever you want with this stuff. If we meet some day,
 * and you think this stuff is worth it, you can buy me a beer in return.
 * -- Joakim Ohlrogge
 */

package com.agical.gsl

import org.eclipse.swt.widgets.{Composite, Layout, Control, Widget}
import org.eclipse.swt.layout._
import org.eclipse.swt.SWT
import Framework._

trait Layouts {

    def layout[T <: Layout](layout:T)(subject:Composite) = {
        subject.setLayout(layout)
        layout
    }

    private def createRowLayout(options:Int, settings:Seq[RowLayout => Unit]) = {
        val theLayout = new RowLayout(options)
        settings foreach(_(theLayout))
        layout(theLayout)(_)
    }

    def fillLayout = layout(new FillLayout)(_)
    
    def columnLayout = createWidget(layout(new RowLayout(SWT.HORIZONTAL)))_

    def rowLayout = createWidget(layout(new RowLayout(SWT.VERTICAL)))_

    def gridLayout = createWidget(layout(new GridLayout()))_

    def horizontal(settings:GridCell => Unit*)(gsl:GSL, target:Control) = {
        val data = target.getLayoutData() match {
            case x:GridData => x
            case _ => new GridData()
        }
        val cell = new GridCell(data.horizontalSpan=_,
                                data.horizontalAlignment=_,
                                data.grabExcessHorizontalSpace=_)
        settings foreach(_(cell))
        target.setLayoutData(data)
    }

    def vertical(settings:GridCell => Unit*)(gsl:GSL, target:Control) = {
        val data = target.getLayoutData() match {
            case x:GridData => x
            case _ => new GridData()
        }
        val cell = new GridCell(data.verticalSpan=_,
                                data.verticalAlignment=_,
                                data.grabExcessVerticalSpace=_)
        settings foreach(_(cell))
        target.setLayoutData(data)
    }

    def span(cols:Int)(target:GridCell) = {
        target.span(cols)
    }

    def fill(target:GridCell) = {target.align(SWT.FILL)}

    def grabExcessSpace(target:GridCell) = {target.grabExcessSpace(true)}

    def columns(n:Int)(gsl:GSL, l:GridLayout) = {
        l.numColumns = n
    }

    def gridData (hAlign:Int, vAlign:Int, excessH:Boolean, excessV:Boolean)(subject:Control) = {
        val gd = new GridData(hAlign, vAlign, excessH, excessV)
        subject.setLayoutData(gd)
    }

    def fill(l:RowLayout) = {l.fill = true}
    
}


class GridCell (val span:Int => Unit, 
                val align:Int => Unit,
                val grabExcessSpace:Boolean => Unit){
    
}

