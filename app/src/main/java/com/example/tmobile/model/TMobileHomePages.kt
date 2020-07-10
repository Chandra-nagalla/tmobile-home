package com.example.tmobile.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

sealed class TMobileBusinessObject

@Parcelize
data class TMobileHomePages(
    val page: Page
) : TMobileBusinessObject(), Parcelable

@Parcelize
data class Page(
    val cards: List<Cards>
) : Parcelable, TMobileBusinessObject()

@Parcelize
data class Cards(
    val card: CardData?,
    val card_type: String
) : Parcelable, TMobileBusinessObject()

@Parcelize
data class CardData(
    val attributes: Attributes? = null,
    val description: Description? = null,
    val image: Image? = null,
    val title: Title? = null,
    val value: String? = null
) : Parcelable, TMobileBusinessObject()

@Parcelize
data class Attributes(
    val font: Font? = null,
    val text_color: String? = null
) : Parcelable, TMobileBusinessObject()

@Parcelize
data class Description(
    val attributes: Attributes,
    val value: String
) : Parcelable, TMobileBusinessObject()

@Parcelize
data class Font(
    val size: Float
) : Parcelable, TMobileBusinessObject()

@Parcelize
data class Title(
    val attributes: Attributes,
    val value: String
) : Parcelable, TMobileBusinessObject()

@Parcelize
data class Image(
    val size: Size,
    val url: String
) : Parcelable, TMobileBusinessObject()

@Parcelize
data class Size(
    val height: Int,
    val width: Int
) : Parcelable, TMobileBusinessObject()


