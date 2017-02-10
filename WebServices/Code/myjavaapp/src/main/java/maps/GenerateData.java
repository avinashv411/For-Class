package maps;

import java.util.Random;

public class GenerateData {
	public static GeocodeResponse generate() {
		LatitudeLongitude latLang = new LatitudeLongitude();
		latLang.setLatitude(new Random().nextDouble());
		latLang.setLongitude(new Random().nextDouble());

		Bounds bounds = new Bounds();
		bounds.setNortheast(latLang);
		bounds.setSouthWest(latLang);

		ViewPort viewport = new ViewPort();
		viewport.setNortheast(latLang);
		viewport.setSouthWest(latLang);

		Geometry geometry = new Geometry();
		geometry.setLocation_type("APPROXIMATE");
		geometry.setLocation(latLang);
		geometry.setBounds(bounds);
		geometry.setViewport(viewport);

		AddressComponent addressComponent = new AddressComponent();
		addressComponent.setLongNM("Bengaluru");
		addressComponent.setShortNM("Bengaluru");
		addressComponent.setType(new String[] { "locality", "political" });

		Result result = new Result();
		result.setPlaceID("ChIJbU60yXAWrjsR4E9-UejD3_g");
		result.setType(new String[] { "locality", "political" });
		result.setFormattedAddress("Bengaluru, Karnataka, India");
		result.setGeometry(geometry);
		result.setAddressComponent(new AddressComponent[] { addressComponent, addressComponent, addressComponent });

		GeocodeResponse googleMapResp = new GeocodeResponse();
		googleMapResp.setStatus("OK");
		googleMapResp.setResult(result);

		return googleMapResp;
	}
}
