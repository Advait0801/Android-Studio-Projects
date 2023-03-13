package com.example.tiptime

import android.app.LocaleManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tiptime.ui.theme.TipTimeTheme
import java.text.NumberFormat
import kotlin.math.ceil

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
    var tip_percent_input by remember { mutableStateOf("") }
    var tip_percent = tip_percent_input.toDoubleOrNull() ?: 0.0
    var roundup by remember { mutableStateOf(false) }
    val tip = TipCalculation(amount , tip_percent , roundup)

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
        TipTextField(
            tip_percent_amount = tip_percent_input,
            changed_tip_percent_amount = { tip_percent_input = it}
        )
        Spacer(modifier = Modifier.height(24.dp))
        RoundUpTip(
            roundup = roundup,
            onRoundup = { roundup = it}
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = stringResource(id = R.string.tip_amount, tip),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }

}

@Composable
fun BillAmountTextField(
    bill_amount: String,
    changed_bill_amount: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val focusManager = LocalFocusManager.current
    OutlinedTextField(
        value = bill_amount,
        onValueChange = changed_bill_amount,
        label = { Text(stringResource(id = R.string.cost_of_service)) },
        modifier = modifier
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
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onNext = { focusManager.moveFocus(FocusDirection.Down) }
        )
    )
}

@Composable
fun TipTextField(
    tip_percent_amount: String,
    changed_tip_percent_amount: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val focusManager = LocalFocusManager.current
    OutlinedTextField(
        value = tip_percent_amount,
        onValueChange = changed_tip_percent_amount,
        label = { Text(stringResource(id = R.string.how_was_the_service)) },
        modifier = modifier
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
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = { focusManager.clearFocus() }
        )
    )
}

@Composable
fun RoundUpTip(
    roundup: Boolean,
    onRoundup: (Boolean) -> Unit,
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .size(48.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = R.string.round_up_tip),
            fontSize = 18.sp
        )
        Switch(
            checked = roundup,
            onCheckedChange = onRoundup,
            modifier = modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End),
            colors = SwitchDefaults.colors(
                uncheckedThumbColor = Color.DarkGray,
                checkedThumbColor = Color.Blue
            )
        )
    }
}

@Composable
fun TipCalculation(
    billamount: Double,
    tip_percent: Double = 15.00,
    roundup: Boolean
): String {
    var tip = (billamount * tip_percent) / 100
    if (roundup){
        tip = ceil(tip)
    }
    return NumberFormat.getCurrencyInstance().format(tip)
}



