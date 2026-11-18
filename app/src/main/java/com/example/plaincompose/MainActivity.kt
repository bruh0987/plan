package com.example.plaincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlainComposeApp()
        }
    }
}

@Composable
fun PlainComposeApp() {
    MaterialTheme(
        colorScheme = MaterialTheme.colorScheme.copy(
            background = Color(0xFF0F0F11),
            surface = Color(0xFF171719),
            onBackground = Color(0xFFF5F3F7),
            onSurface = Color(0xFFF5F3F7),
        ),
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                Text(
                    text = "1c  •  Plan lekcji",
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color(0xFFF5F3F7),
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = "Widget added to the Android widget picker",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFFAAA7B0),
                )
                SchedulePreview()
            }
        }
    }
}

@Composable
private fun SchedulePreview() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF171719), RoundedCornerShape(12.dp))
            .padding(6.dp),
        verticalArrangement = Arrangement.spacedBy(3.dp),
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Box(modifier = Modifier.weight(0.7f))
            ScheduleDays.forEach { day ->
                Text(
                    text = day.take(3).uppercase(),
                    modifier = Modifier.weight(1f),
                    color = Color(0xFFF5F3F7),
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                )
            }
        }

        ScheduleLessons.forEachIndexed { rowIndex, lessons ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(46.dp),
                horizontalArrangement = Arrangement.spacedBy(3.dp),
            ) {
                Column(
                    modifier = Modifier.weight(0.7f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    Text(
                        text = "${rowIndex + 1}",
                        color = Color(0xFFF5F3F7),
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text = ScheduleTimes[rowIndex].replace(" - ", "\n"),
                        color = Color(0xFFAAA7B0),
                        fontSize = 7.sp,
                        textAlign = TextAlign.Center,
                        lineHeight = 8.sp,
                    )
                }

                lessons.forEach { lesson ->
                    val cardColor = if (lesson.name.isBlank()) {
                        Color(0xFF252529)
                    } else {
                        Color(lesson.color)
                    }
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxSize()
                            .background(cardColor, RoundedCornerShape(5.dp))
                            .padding(horizontal = 2.dp, vertical = 3.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                    ) {
                        if (lesson.room.isNotBlank()) {
                            Text(
                                text = lesson.room,
                                color = Color(0xAA171719),
                                fontSize = 7.sp,
                            )
                        }
                        if (lesson.name.isNotBlank()) {
                            Text(
                                text = lesson.name,
                                color = Color(0xFF171719),
                                fontSize = 9.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                maxLines = 2,
                            )
                            if (lesson.teacher.isNotBlank()) {
                                Text(
                                    text = lesson.teacher,
                                    color = Color(0xCC171719),
                                    fontSize = 6.sp,
                                    textAlign = TextAlign.Center,
                                    maxLines = 1,
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PlainComposeAppPreview() {
    PlainComposeApp()
}
