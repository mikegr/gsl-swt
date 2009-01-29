/*
 * The file is licenced under Revision 42 of the Beerware Licence.
 * <joakim.ohlrogge[at]agical.com> wrote this file. As long as you retain this
 * notice you can do whatever you want with this stuff. If we meet some day,
 * and you think this stuff is worth it, you can buy me a beer in return.
 * -- Joakim Ohlrogge
 */

package com.agical.gsl

import org.eclipse.swt.widgets.{Composite, Label, ProgressBar, Widget}
import org.eclipse.swt.SWT
import Framework._

trait Labels {
    def label = createWidget(new Label(_, SWT.NONE))_
    def progressBar = createWidget(new ProgressBar(_, SWT.NONE))_
}