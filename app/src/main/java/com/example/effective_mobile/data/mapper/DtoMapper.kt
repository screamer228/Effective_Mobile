package com.example.effective_mobile.data.mapper

import com.example.effective_mobile.data.offers.model.response.OffersResponse
import com.example.effective_mobile.data.offers.model.dto.OfferDTO
import com.example.effective_mobile.data.offers.model.dto.OffersDTO

class DtoMapper {

    fun mapOffersDTO(response: OffersResponse): OffersDTO {
        val mappedOffers = response.offersResponse.map { offerResponse ->
            val imageUrl = when (offerResponse.id) {
                1 -> {
                    IMG_URL_1
                }

                2 -> {
                    IMG_URL_2
                }

                else -> {
                    IMG_URL_3
                }
            }

            OfferDTO(imageUrl, offerResponse.title, offerResponse.town, offerResponse.price.value.toString())
        }
        return OffersDTO(mappedOffers)
    }
}

private const val IMG_URL_1 =
    "https://s3-alpha-sig.figma.com/img/50e5/7703/05c9ccd1fe0c75a7447cfd59dcce0842?Expires=1714953600&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=Tgtdms0DJ3r4GCSqMGf4el4rm3Qx2eRc~THYDhCmxp7NZ4e~D-76XNC3HvDjvHfI0pEl9-O9C5yWuUtK0gl2AHWkZLvDzV4m~TN0f06J7NGBdfm7-wsssgBpl0nzGYqfrzY7fCVRKTu3qBZU36NaTrTQrVnui-VvCjrfQ~qpi4l0XdAT0Vmr8TTj~74hCm7Jv0pCYvKm7lo~tbIHf-yju7Jvzx1ush84WuavwyHeIdBQQmEsBEzrtYcRgZESwad8f~8b8fpcZ6znN8jCoL1XuE1AgGqWCZyV6kxepaJi9t4f4DEBlIfufuhu6Vc8NqQGqXxxxNtbtuWIWO8flXXoRQ__"
private const val IMG_URL_2 =
    "https://s3-alpha-sig.figma.com/img/7ee0/2366/49ac0bef4b3a0bbe25b20342dccbb8f3?Expires=1714953600&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=L83dNV1kLsQPFasMhxMsWFfHcO9VfhlECbJAYI7ieQwk472pQYQ8QmehbdHpTAi2Y9jofp6C0CfLpUtQdvefUaJXmUvqTFiH5Saklc0WJ11WTHX4PADA4lqmS4Etr-Bqk5gbvCAodW0TnRtur1pajjDerK8GP33ovmB-5i4qDmQzwzIJbcJUnBk7-JEbqY9CvejF~hUlDI0yZkmtMXDWmtvMl1yq1QgDTMEQvG2IRAkrdIcvx2H-MxiGnPrtUyQ3zaCnBsPmLkIMcu53Wssol6lsca5eMV-jPb14OVB7oQLHgjNeqCLSAXJWEH~tG-4nFnoKe4PEFRlUAdrFBYEI3A__"
private const val IMG_URL_3 =
    "https://s3-alpha-sig.figma.com/img/52b5/fb72/4e159245d20766d9474526f6e4e7d452?Expires=1714953600&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=gm83bFB2lZvr404mrpEOjrqo0uO~-xWOVtoiRiGlaKjersQkdzyECHnwUrXnqro193oqX9nbDyNP434G-YKYPWgzYSPD3YkjWWLVfaYwSz99hPV1q1R2f7PQNEl0WqPsEnq-tZcRHoim1-279SlN2R5pKLF5gfkIIfEO64ys0bjjGv3c6fp9uybQUHb5tCpoBx9aI9Q45EIgSOgIvD7MvLBe1MyL7lSDERa8~yK-PfXmjpmGYJmsif5RDoPBSk1Tvh-QKjcc4lNjd244~-JuAALNToWk-0a0EvusUC~tkRiIEcI9ImozR9~z8KWZCrIn2SbvWzKFX0pcdneuBJjzRw__"
