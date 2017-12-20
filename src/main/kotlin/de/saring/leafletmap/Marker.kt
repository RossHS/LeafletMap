package de.saring.leafletmap

/**
 * Creates a marker at the specified geographical position.
 *
 * @author Niklas Kellner
 *
 * @param position marker position
 * @param title marker title shown in tooltip (pass empty string when tooltip not needed)
 * @param zIndexOffset zIndexOffset (higher number means on top)
 *
 */
class Marker private constructor(private var position: LatLong, private var title: String, private var zIndexOffset: Int) {
    private var marker = ColorMarker.RED_MARKER.iconName
    private lateinit var map : LeafletMapView

    private var name = ""

    /**
     * Creates a marker at the specified geographical position.
     *
     * @param position marker position
     * @param title marker title shown in tooltip (pass empty string when tooltip not needed)
     * @param marker marker color
     * @param zIndexOffset zIndexOffset (higher number means on top)
     * @return variable name of the created marker
     */
    constructor(position: LatLong, title: String, marker: ColorMarker, zIndexOffset: Int) : this(position, title, zIndexOffset) {
        this.marker = marker.iconName
    }

    /**
     * Creates a marker at the specified geographical position.
     *
     * @param position marker position
     * @param title marker title shown in tooltip (pass empty string when tooltip not needed)
     * @param marker marker color
     * @param zIndexOffset zIndexOffset (higher number means on top)
     * @return variable name of the created marker
     */
    constructor(position: LatLong, title: String, marker: String, zIndexOffset: Int) : this(position, title, zIndexOffset) {
        this.marker = marker
    }

    /**
     * Adds the marker to a map, gets called from the mapAddMarker
     *
     * @param nextMarkerName the variable name of the marker
     * @param map the LeafetMapView
     */
    internal fun addToMap(nextMarkerName: String, map: LeafletMapView) {
        this.name = nextMarkerName
        this.map = map
        map.execScript("var $name = L.marker([${position.latitude}, ${position.longitude}], "
                + "{title: '$title', icon: ${marker}, zIndexOffset: $zIndexOffset}).addTo(myMap);")
    }

    /**
     * Changes the icon of the marker
     *
     * @param newIcon the name of the new icon
     */
    fun changeIcon(newIcon: String) {
        map.execScript("$name.setIcon($newIcon);")
    }

    /**
     * Changes the icon of the marker
     *
     * @param newIcon the new ColorMarker
     */
    fun changeIcon(newIcon: ColorMarker) {
        map.execScript("$name.setIcon(${newIcon.iconName});")
    }

    /**
     * Moves the existing marker specified by the variable name to the new geographical position.
     *
     * @param position new marker position
     */
    fun move(position: LatLong) {
        map.execScript("$name.setLatLng([${position.latitude}, ${position.longitude}]);")
    }

    /**
     * Sets the marker clickable
     */
    fun setClickable() {
        map.execScript("$name.on('click', function(e){ document.java.markerClick($name.options.title)})")
    }

    internal fun getName(): String = this.name
}