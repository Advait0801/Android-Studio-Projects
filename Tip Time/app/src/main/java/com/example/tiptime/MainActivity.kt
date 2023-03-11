package com.example.tiptime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tiptime.ui.theme.TipTimeTheme
import java.text.NumberFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipTimeTheme {
                TipTimeApp()
            }
        }
    }
}

@Preview
@Composable
fun TipTimeApp() {
    var bill_input by remember { mutableStateOf("") }
    val amount = bill_input.toDoubleOrNull() ?: 0.0
    val tip = TipCalculation(amount)

    Column(
        modifier = Modifier.padding(32.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = stringResource(id = R.string.calculate_tip),
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(Modifier.height(16.dp))
        BillAmountTextField(
            bill_amount = bill_input,
            changed_bill_amount = { bill_input = it }
        )
        Spacer(Modifier.height(24.dp))
        Text(
            text = stringResource(id = R.string.tip_amount, tip),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }

}

@Composable
fun BillAmountTextField(
    bill_amount: String,
    changed_bill_amount: (String) -> Unit
) {
    OutlinedTextField(
        value = bill_amount,
        onValueChange = changed_bill_amount,
        label = { Text(stringResource(id = R.string.cost_of_service)) },
        modifier = Modifier
            .fillMaxWidth(),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color.DarkGray,
            focusedBorderColor = Color.Blue,
            unfocusedLabelColor = Color.Gray,
            focusedLabelColor = Color.Blue,
            cursorColor = Color.Blue,
            backgroundColor = Color.LightGray
        ),
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),

    )
}
@Composable
fun TipCalculation(
    billamount: Double,
    tip_percent: Double = 15.00
): String {
    val tip = (billamount * tip_percent) / 100
    return NumberFormat.getCurrencyInstance().format(tip)
}



