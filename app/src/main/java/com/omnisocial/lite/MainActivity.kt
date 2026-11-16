package com.omnisocial.lite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.isSystemInDarkTheme

private enum class MainTab(val title: String, val symbol: String) {
    Home("Home", "⌂"),
    Friends("Friends", "♧"),
    Create("Create", "+"),
    Messages("Messages", "✉"),
    Menu("Menu", "☰")
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { OmniSocialApp() }
    }
}

@Composable
private fun OmniSocialApp() {
    val dark = isSystemInDarkTheme()
    MaterialTheme(
        colorScheme = if (dark) darkColorScheme() else lightColorScheme()
    ) {
        var selectedTab by remember { mutableIntStateOf(0) }

        Scaffold(
            bottomBar = {
                NavigationBar {
                    MainTab.entries.forEachIndexed { index, tab ->
                        NavigationBarItem(
                            selected = selectedTab == index,
                            onClick = { selectedTab = index },
                            icon = { Text(tab.symbol) },
                            label = { Text(tab.title) }
                        )
                    }
                }
            }
        ) { padding ->
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                color = MaterialTheme.colorScheme.background
            ) {
                MainScreen(tab = MainTab.entries[selectedTab])
            }
        }
    }
}

@Composable
private fun MainScreen(tab: MainTab) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 18.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "OmniSocial",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Lite • Privacy first",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Text("OS", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
        }

        when (tab) {
            MainTab.Home -> HomeContent()
            MainTab.Friends -> UnavailableContent(
                title = "Friends",
                detail = "Friend-list access is not assumed. This screen will use only an officially supported Meta API and approved permission."
            )
            MainTab.Create -> UnavailableContent(
                title = "Create a post",
                detail = "Posting is not connected yet. It will be enabled only for an officially supported publishing endpoint and approved account/Page permissions."
            )
            MainTab.Messages -> UnavailableContent(
                title = "Messages",
                detail = "Personal Messenger inbox access is not assumed. Page messaging has separate API, review, and infrastructure requirements."
            )
            MainTab.Menu -> MenuContent()
        }
    }
}

@Composable
private fun HomeContent() {
    StatusCard(
        title = "Your privacy comes first",
        body = "No OmniSocial-owned server, database, analytics, ad SDK, or tracking service is configured."
    )
    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
        Text("Your feed", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.SemiBold)
        Text(
            "Live Facebook feed is not connected. Meta's official API access is permission-limited; this app will not show fake posts.",
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
    StatusCard(
        title = "Official integration review",
        body = "Only documented Meta APIs and permissions will be used. Some Facebook Lite features may not be available to third-party apps."
    )
}

@Composable
private fun MenuContent() {
    Text("Settings & privacy", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.SemiBold)
    StatusCard(
        title = "Data storage",
        body = "The app is designed to keep only essential preferences and temporary cache on this device. Storage controls are planned."
    )
    StatusCard(
        title = "Permissions",
        body = "The initial build requests Internet access only. Media permissions will be avoided where Android's system Photo Picker is sufficient."
    )
    StatusCard(
        title = "Theme",
        body = "The interface currently follows Android's system light/dark appearance."
    )
}

@Composable
private fun UnavailableContent(title: String, detail: String) {
    Text(title, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.SemiBold)
    StatusCard(title = "Not connected", body = detail)
}

@Composable
private fun StatusCard(title: String, body: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
            Text(body, style = MaterialTheme.typography.bodyMedium)
        }
    }
}
