package com.rumosoft.widgettester

import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.glance.appwidget.testing.unit.runGlanceAppWidgetUnitTest
import androidx.glance.testing.unit.assertHasClickAction
import androidx.glance.testing.unit.hasText
import com.rumosoft.widgettester.widget.SampleWidget
import org.junit.Test

class WidgetContentKtTest {
    @Test
    fun widgetContent_checkTextContent() = runGlanceAppWidgetUnitTest {
        setAppWidgetSize(DpSize(200.dp, 100.dp))

        provideComposable {
            SampleWidget()
        }

        onNode(hasText("678 46 11 44"))
            .assertExists()
        onNode(hasText("0 GB"))
            .assertExists()
        onNode(hasText("de 6 GB"))
            .assertExists()
    }

    @Test
    fun widgetContent_checkClickableButtons() = runGlanceAppWidgetUnitTest {
        setAppWidgetSize(DpSize(200.dp, 100.dp))

        provideComposable {
            SampleWidget()
        }

        onNode(hasText("a las 13:40"))
            .assertHasClickAction()
    }
}