package com.rumosoft.widgettester

import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.glance.appwidget.testing.unit.runGlanceAppWidgetUnitTest
import androidx.glance.testing.unit.assertHasClickAction
import androidx.glance.testing.unit.hasContentDescription
import androidx.glance.testing.unit.hasText
import com.rumosoft.widgettester.widget.SampleOverflowedWidget
import com.rumosoft.widgettester.widget.SampleWidget
import org.junit.Test

class WidgetContentKtTest {
    @Test
    fun widgetContent_checkTextContent() = runGlanceAppWidgetUnitTest {
        setAppWidgetSize(TEST_WIDGET_SIZE)

        provideComposable {
            SampleWidget()
        }

        onNode(hasText("678 46 11 44"))
            .assertExists()
        onNode(hasText("2.0 GB"))
            .assertExists()
        onNode(hasText("de 6 GB"))
            .assertExists()
        onNode(hasContentDescription("Overflowed"))
            .assertDoesNotExist()
    }

    @Test
    fun widgetContent_checkClickableButtons() = runGlanceAppWidgetUnitTest {
        setAppWidgetSize(TEST_WIDGET_SIZE)

        provideComposable {
            SampleWidget()
        }

        onNode(hasText("a las 13:40"))
            .assertHasClickAction()
    }

    @Test
    fun widgetContent_checkOverflowed() = runGlanceAppWidgetUnitTest {
        setAppWidgetSize(TEST_WIDGET_SIZE)

        provideComposable {
            SampleOverflowedWidget()
        }

        onNode(hasContentDescription("Overflowed"))
            .assertExists()
    }

    companion object {
        private val TEST_WIDGET_SIZE = DpSize(200.dp, 100.dp)
    }
}