package com.plcoding.cryptocurrencyappyt.presentation.coinDetail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.plcoding.cryptocurrencyappyt.data.remote.dto.TeamMember

@Composable
@Preview
fun TeamListItem(
    @PreviewParameter(SampleTeamMemberProvider::class) teamMember: TeamMember,
    modifier: Modifier = Modifier
) {

    Column(modifier = modifier, verticalArrangement = Arrangement.Center) {
        Text(
            text = teamMember.name.orEmpty(),
            style = MaterialTheme.typography.h4,
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = teamMember.name.orEmpty(),
            style = MaterialTheme.typography.body2,
            fontStyle = FontStyle.Italic
        )
    }

}

class SampleTeamMemberProvider : PreviewParameterProvider<TeamMember> {
    override val values = sequenceOf(
        TeamMember(name = "Juliana R Brondani", id = "56", position = "CEO"),
        TeamMember(name = "Alan Munhoz", id = "07", position = "CTO")
    )
}