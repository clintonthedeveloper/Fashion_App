package com.clinton.fashionapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.clinton.fashionapp.R

@Composable
fun ProductScreen(navController: NavController) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White,
                shape = RectangleShape
            )
    ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                painter = painterResource(id = R.drawable.ic_arrow_back),
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .clickable(
                        interactionSource = remember {
                            MutableInteractionSource()
                        },
                        indication = null
                    ) {
                        navController.navigateUp()
                    }
            )
            Text(
                text = "Products",
                modifier = Modifier
                    .weight(1f),
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
                )
            Image(
                painter = painterResource(id = R.drawable.ic_cart),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        }
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(top = 8.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.showcase_item_5),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 40.dp, end = 40.dp)
                    .clip(shape = CircleShape)
            )
            Row (
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                repeat(3){ index ->
                    Box(
                        modifier = Modifier
                            .padding(4.dp)
                            .size(if (index == 1) 10.dp else 8.dp)
                            .background(
                                color = if (index == 1) Color(android.graphics.Color.parseColor("#509790")) else Color.Gray,
                                shape = CircleShape
                            )
                    )
                }
            }
            Row (
                modifier = Modifier
                    .padding(top = 20.dp, start = 48.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                ProductImage(image = R.drawable.showcase_item_1, offset = 0)
                ProductImage(image = R.drawable.list_item_2, offset = -12)
                ProductImage(image = R.drawable.list_item_3, offset = -24)
                ProductImage(image = R.drawable.list_item_4, offset = -36)
                ProductImage(image = R.drawable.list_item_5, offset = -48)
            }
            Row (
                modifier = Modifier
                    .padding(top = 20.dp, start = 24.dp, end = 24.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "Hallowin Shirt",
                    modifier = Modifier.weight(1f),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                repeat(5){
                    Image(
                        painter = painterResource(id = R.drawable.ic_star),
                        contentDescription = null,
                    )
                }
            }
            Text(text = "This is a Fashion of a nice afro american young people with nice locks wearing" +
            "hallawiin short sleeved shirt. Studio shoot on a board background.",
                modifier = Modifier
                    .padding(
                        top = 20.dp, start = 24.dp,
                        end = 24.dp
                    )
                    .weight(1f),
                fontSize = 16.sp
                )
            Row (
                modifier = Modifier
                    .padding(start = 24.dp)
                    .weight(1f),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                ProductSize(sizeText = "S")
                ProductSize(sizeText = "M")
                ProductSize(sizeText = "L")
                ProductSize(sizeText = "XL")

            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column (modifier = Modifier.weight(1f)){
                Text(
                    text = "Price",
                    modifier = Modifier.wrapContentWidth(),
                    textAlign = TextAlign.Center
                    )
                Text(
                    text = "$25.99",
                    modifier = Modifier
                        .wrapContentWidth()
                        .padding(top = 4.dp),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                    )
            }
            Row (
                modifier = Modifier
                    .background(
                        Color(android.graphics.Color.parseColor("#509790")),
                        RoundedCornerShape(40.dp)
                    )
                    .padding(12.dp),
            ){
                Image(
                    painter = painterResource(id = R.drawable.ic_bag),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    colorFilter = ColorFilter.tint(color = Color.White)
                )
                Text(
                    text = "Add to cart",
                    modifier = Modifier.padding(start = 8.dp),
                    textAlign = TextAlign.Center,
                    color = Color.White
                    )
            }
        }
    }
}

@Composable
fun ProductImage(image: Int, offset: Int) {
    Image(
        painter = painterResource(id = image),
        contentDescription = null,
        modifier = Modifier
            .offset(x = offset.dp)
            .size(48.dp)
            .clip(shape = CircleShape)
            .border(
                width = 2.dp,
                color = Color.White,
                shape = CircleShape
            )
    )
}

@Composable
fun ProductSize(sizeText: String) {
    Box(
        modifier = Modifier
            .padding(end = 8.dp)
            .wrapContentWidth()
            .size(48.dp)
            .border(width = 1.dp, Color.Gray, shape = CircleShape),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = sizeText,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
    }
}

@Preview
@Composable
private fun ProductScreenPreview() {
    ProductScreen(navController = rememberNavController())
}