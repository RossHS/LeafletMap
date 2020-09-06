package de.saring.leafletmap

/**
 * Enumeration for all marker colors of the leaflet-color-markers JavaScript library.
 *
 * @author Stefan Saring
 */
enum class MarkerIcon(val iconName: String) {

    BLUE_MARKER("blueIcon"),
    RED_MARKER("redIcon"),
    GREEN_MARKER("greenIcon"),
    ORANGE_MARKER("orangeIcon"),
    YELLOW_MARKER("yellowIcon"),
    VIOLET_MARKER("violetIcon"),
    GREY_MARKER("greyIcon"),
    BLACK_MARKER("blackIcon"),
    DRONE_NORMAL("droneNormalIcon"),
    DRONE_WARNING("droneWarningIcon"),
    DRONE_ERROR("droneErrorIcon"),
    ANTENNA_NORMAL("antennaNormalIcon"),
    ANTENNA_WARNING("antennaWarningIcon"),
    ANTENNA_ERROR("antennaErrorIcon")
}
