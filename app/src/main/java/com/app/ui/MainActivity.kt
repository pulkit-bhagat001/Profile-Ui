package com.app.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.CurrencyRupee
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.Speed
import androidx.compose.material.icons.outlined.Chat
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.ui.ui.theme.UiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UiTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProfileScreen(modifier = Modifier.padding(innerPadding))


                }
            }
        }
    }

    @Composable
    fun ProfileScreen(modifier: Modifier) {
        Surface(
            color = Color(0xFF161616),
            modifier = modifier.fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier
            ) {
                item{
                    TopBar()

                    ProfileHeader()

                    CredGarageCard()

                    InfoRows()

                    RewardsSection()

                    TransactionsSection()
                }

            }
        }
    }

    @Composable
    fun TopBar() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF161616))
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(Icons.Default.ArrowBack, contentDescription = null, tint = Color.White)
            Text("Profile", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            OutlinedCard(colors = CardDefaults.cardColors(containerColor = Color(0xFF161616)),
                border = BorderStroke(width = 0.5.dp, color = Color(0xFF2A2A2A)), shape = RoundedCornerShape(20.dp)) {
                Row(Modifier
                    .padding(8.dp)
                    .padding(horizontal = 5.dp), horizontalArrangement = Arrangement.spacedBy(5.dp), verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        Icons.Outlined.Chat,
                        contentDescription = null,
                        tint = Color.Gray,
                        modifier = Modifier.size(17.dp),
                    )
                    Text("Support", color = Color.Gray, fontSize = 12.sp)
                }
            }

        }
    }

    @Composable
    fun ProfileHeader() {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
            .background(Color(0xFF161616))
            .padding(16.dp)) {
            Image(
                painter = painterResource(id = R.drawable.placeholder),
                contentDescription = null,
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray, CircleShape)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text("andaz Kumar", color = Color.White, fontWeight = FontWeight.Bold)
                Text("member since Dec, 2020", color = Color.Gray)
            }
            Spacer(modifier = Modifier.weight(1f))
            OutlinedCard(shape = RoundedCornerShape(20.dp), colors = CardDefaults.cardColors(containerColor = Color(0xFF161616)), border = BorderStroke(width = 1.dp, color = Color(0xFF2A2A2A))) {
                Icon(Icons.Outlined.Edit, contentDescription = null, tint = Color.Gray, modifier = Modifier.padding(8.dp))
            }

        }
    }

    @Composable
    fun CredGarageCard() {
        OutlinedCard(
            colors = CardDefaults.cardColors(containerColor = Color(0xFF121212)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 5.dp)
                .padding(bottom = 45.dp),
            shape = RoundedCornerShape(0.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
            border = BorderStroke(width = 1.dp, color = Color(0xFF2A2A2A))

        ) {
            Row(
                modifier = Modifier.padding(25.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                OutlinedCard(shape = RoundedCornerShape(20.dp), colors = CardDefaults.cardColors(containerColor = Color(0xFF161616)), border = BorderStroke(width = 1.dp, color = Color.White)) {
                    Icon(Icons.Default.DirectionsCar, contentDescription = null, tint = Color.White, modifier = Modifier.padding(8.dp))
                }
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(
                        "get to know your vehicles, inside out",
                        color = Color.White,
                        fontSize = 13.sp
                    )
                    Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                        Text("CRED garage", color = Color.LightGray)
                        Icon(imageVector = Icons.Filled.ArrowForward, contentDescription = null, tint = Color.LightGray)
                    }

                }
            }
        }
    }

    @Composable
    fun InfoRows() {
        InfoRow("credit score", "757", "• REFRESH AVAILABLE", Color.Green, imageVector = Icons.Filled.Speed)
        InfoRow("lifetime cashback", "₹3", imageVector = Icons.Filled.CurrencyRupee)
        InfoRow("bank balance", "check", imageVector = Icons.Filled.CurrencyRupee)
    }

    @Composable
    fun InfoRow(
        label: String,
        value: String,
        subLabel: String = "",
        subLabelColor: Color = Color.Gray,
        imageVector: ImageVector
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp, horizontal = 20.dp)
                    .padding(bottom = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {


                Column {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        if(label!="all transactions"){
                            OutlinedCard(shape = RoundedCornerShape(20.dp), colors = CardDefaults.cardColors(containerColor = Color(0xFF161616)), border = BorderStroke(width = 1.dp, color = Color(0xFF2A2A2A)), modifier = Modifier.padding(end = 5.dp)) {
                                Icon(imageVector, contentDescription = null, tint = Color.Gray, modifier = Modifier.size(25.dp).padding(5.dp))
                            }
                        }

                        Text(label, color = Color.White)

                        if (subLabel.isNotEmpty()) {
                            Spacer(modifier = Modifier.width(4.dp))

                            Text(subLabel, color = subLabelColor, fontSize = 12.sp)

                        }

                    }

                }
                Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text(value, color = Color.White)
                    Icon(imageVector = Icons.Filled.ArrowForward, contentDescription = null, tint = Color.Gray)

                }



            }
            Row(Modifier.padding(horizontal = 20.dp)) {
                Divider(Modifier.fillMaxWidth(), color = Color(0xFF2A2A2A))
            }

        }
    }

    @Composable
    fun RewardsSection() {
        Column(modifier = Modifier
            .background(Color(0xFF0D0D0D))
            .padding(16.dp)) {
            Text("YOUR REWARDS & BENEFITS", color = Color.Gray, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(18.dp))
            RewardsColumn(text1 = "cashback balance", text2 = "₹0")
            RewardsColumn(text1 = "coins", text2 = "26,46,583")
            RewardsColumn(text1 = "win upto Rs 1000", text2 ="refer and earn")
            Spacer(modifier = Modifier.height(28.dp))
            Text("TRANSACTIONS & SUPPORT", color = Color.Gray, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            InfoRow("all transactions", "", imageVector = Icons.Filled.CurrencyRupee)



        }
    }

    @Composable
    fun RewardsColumn(text1: String,text2: String) {
        Column(modifier= Modifier.padding(bottom = 16.dp, start = 16.dp, end = 16.dp)) {
            Row (horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
                Text(text1, color = Color.White)
                Icon(imageVector = Icons.Filled.ArrowForwardIos,contentDescription = null, tint = Color.Gray, modifier = Modifier.size(17.dp))
            }
            Row {
                Text(text2, color = Color.Gray)
            }
            Spacer(Modifier.height(15.dp))
            Row {
                Divider(Modifier.fillMaxWidth(), color = Color(0xFF2A2A2A))
            }
        }
    }

    @Composable
    fun TransactionsSection() {
    Box(Modifier
        .fillMaxSize()
        .background(Color(0xFF0D0D0D))){

    }

    }


}

