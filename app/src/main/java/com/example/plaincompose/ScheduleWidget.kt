package com.example.plaincompose

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.appwidget.cornerRadius
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Box
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.padding
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextAlign
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider
import androidx.glance.layout.Spacer
import androidx.glance.layout.height
import androidx.glance.layout.width

class ScheduleWidget : GlanceAppWidget() {
    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            ScheduleWidgetContent()
        }
    }
}

class ScheduleWidgetReceiver : GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget = ScheduleWidget()
}

@Composable
private fun ScheduleWidgetContent() {
    Column(
        modifier = GlanceModifier
            .fillMaxSize()
            .background(ColorProvider(Color(0xFF171719)))
            .padding(5.dp),
    ) {
        Row(
            modifier = GlanceModifier.fillMaxWidth().height(24.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Spacer(modifier = GlanceModifier.width(42.dp))
            ScheduleDays.forEach { day ->
                Text(
                    text = day.take(3).uppercase(),
                    modifier = GlanceModifier.width(46.dp),
                    style = TextStyle(
                        color = ColorProvider(Color(0xFFF5F3F7)),
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontSize = 10.sp,
                    ),
                )
            }
        }

        ScheduleLessons.forEachIndexed { rowIndex, lessons ->
            Row(
                modifier = GlanceModifier.fillMaxWidth().height(50.dp),
            ) {
                Box(
                    modifier = GlanceModifier.width(42.dp).fillMaxSize(),
                    contentAlignment = Alignment.Center,
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "${rowIndex + 1}",
                            style = TextStyle(
                                color = ColorProvider(Color(0xFFF5F3F7)),
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                fontSize = 10.sp,
                            ),
                        )
                        Text(
                            text = ScheduleTimes[rowIndex],
                            style = TextStyle(
                                color = ColorProvider(Color(0xFFAAA7B0)),
                                textAlign = TextAlign.Center,
                                fontSize = 7.sp,
                            ),
                        )
                    }
                }

                lessons.forEach { lesson ->
                    Box(
                        modifier = GlanceModifier
                            .width(46.dp)
                            .fillMaxSize()
                            .padding(1.dp)
                            .cornerRadius(5.dp)
                            .background(
                                ColorProvider(
                                    if (lesson.name.isBlank()) Color(0xFF252529) else Color(lesson.color),
                                ),
                            ),
                        contentAlignment = Alignment.Center,
                    ) {
                        if (lesson.name.isNotBlank()) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                if (lesson.room.isNotBlank()) {
                                    Text(
                                        text = lesson.room,
                                        style = widgetTextStyle(0xAA171719, 7),
                                    )
                                }
                                Text(
                                    text = lesson.name,
                                    style = widgetTextStyle(0xFF171719, 9),
                                )
                                if (lesson.teacher.isNotBlank()) {
                                    Text(
                                        text = lesson.teacher,
                                        style = widgetTextStyle(0xCC171719, 7),
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

private fun widgetTextStyle(color: Long, size: Int) = TextStyle(
    color = ColorProvider(Color(color)),
    textAlign = TextAlign.Center,
    fontWeight = if (size >= 9) FontWeight.Bold else FontWeight.Normal,
    fontSize = size.sp,
)
