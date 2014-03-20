package es.tid.neosdp.multipart;

import static org.junit.Assert.fail;
import junit.framework.Assert;

import org.junit.Test;

public class MultipartWithoutContentTypeTest {
	
	private String contentEncoding="UTF-8";
	
	private String multipartContent ="--URFNfBE4vb9UxaPOU9e_bBkq1WiwQroju3XgnN\n"+
			"Content-Disposition: form-data; name=\"root-fields\"\n"+
			"Content-Transfer-Encoding: 8bit\n"+
			"\n"+
			"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n"+
			"<message xmlns=\"http://www.telefonica.com/schemas/UNICA/REST/mms/v1/\">\n"+
			"  <address>\n"+
			"    <phoneNumber xmlns=\"http://www.telefonica.com/schemas/UNICA/REST/common/v1\">445480605</phoneNumber>\n"+
			"  </address>\n"+
			"  <originAddress>\n"+
			"    <alias xmlns=\"http://www.telefonica.com/schemas/UNICA/REST/common/v1\">70463705b114236db585ce6177f03074</alias>\n"+
			"  </originAddress>\n"+
			"  <subject>SANDlaboinaapp MMS subject</subject>\n"+
			"</message>\n"+
			"\n"+
			"--URFNfBE4vb9UxaPOU9e_bBkq1WiwQroju3XgnN\n"+
			"Content-Disposition: form-data; name=\"attachments\"\n"+
			"Content-Type: multipart/mixed; boundary=asdfAErweSDFRwe234sf_q765ASDdweewhKUTR\n"+
			"\n"+
			"--asdfAErweSDFRwe234sf_q765ASDdweewhKUTR\n"+
			"Content-Disposition: attachment; fileName=\"message.txt\"\n"+
			"Content-Type: text/plain;charset=UTF-8\n" +
			"Content-Transfer-Encoding: 8bit\n" +
			"\n"+
			"This is a multimedia message\n"+
			"\n" +
			"--asdfAErweSDFRwe234sf_q765ASDdweewhKUTR\n"+
			"Content-Disposition: attachment; fileName=\"picture.jpg\"\n"+
			"Content-Type: image/jpeg\n" +
			"Content-Transfer-Encoding: base64\n" +
			"\n" +
			"R0lGODlhXgAhAPcAALzO2bnN2CFliTBxktHc5FGHo0B9m0V/nT15mYyuwJW1xunr71qOqGiVrjh2\n" + 
			"lglWfhRehGKSrPH19u3z9nmht8fV39Te5fb2+LLI1cvZ4uHm7M7e5RFcgv/+/u/w806FoS1ukCVq\n" +
			"jfr4+rHH1KrC0FmMpkiBn/Pz9YGmu5m3x/n1+aXAzkN9mwlYfxhhhv76+qK+zCpsj2GRq1qKptHc\n" +
			"48PS3MTS3Zq1xlOIpN3k6rDE0omrv6zE0QJSew9agcrX4MPU3l6Rq5+7y6nBz2WUrRBbgb7Q2tHa\n" +
			"41SJpMzl6vb19/Xz9u3u8oOovAZUfW2ZsB5kieDl6qS9zS5wkb3R3Onv8+Ts8ePq77vN13yiuP/9\n" +
			"/Pb6+o+wwvDx9O/v8+rt8Iaqvtvl69jl656+zdni6UJ7mn6kugRUfHKetMnW33Cbsm6bshdghbbK\n" +
			"1jp4l0Z/nXSdtBJdg/v8/R5limaVrvPz9kyDoRliiOvv8RhghYytwChsj4Gou9bi6Nfg5xxkiczZ\n" +
			"4cPR3GeUrQFSeyNojAxZgKG8yzd1lleKpjV0lVWKpZ25yZq4yZCxxJKxwhxjhxpih0mBnxVfhIap\n" +
			"vHeft3GdsxlfhWWTrQNSewFRegtYf0N+nDp2lwdWfmWVrsHT3f/+/bTJ1XSetaG7y+nt8BRfhCxu\n" +
			"jzd2litujzJylLfN2G6bseXr8A5ZgcbT3ZWzxjx3l2aWrtLb5JCuwmiXrmWasRlih+vy9dfk6Q5a\n" +
			"gr7W4FKIo2OTrbnR2r7U3x5jiPHz9QdWfUeCoKzC0MDR3A9cgrTH1LLI012OqJO6ydrm68jc426c\n" +
			"s3WdtgNTe3SftgNUfCdrjk+BngVSfHujuHmkuc/Z4wVWfjN0lAZVfTNyk6zI1W+ZsVeJpSZoi9Hj\n" +
			"6eTp7eXo7gRUe+Tq7ebp7s3Z4szb487Z4cHR28/b4565yZ65ytnk6XagtgxagHWiuLfM17TJ1rXK\n" +
			"1iFni3WdtDd0lTd2lR1liufr7uzv8naftQJResTR3MPT3v///wBReiH5BAAAAAAALAAAAABeACEA\n" +
			"AAj/AP8JHEiwoMGDCBMqXMiwocOHECNKnEixosWLGDNq3MiwRxwoqUy8cQPi0IGTmw54QtICYotE\n" +
			"Bg582MMRYyYEKTTg6VKnC5k+W0B98cDzBIFdA/OwWdgAABAFOwKJSHCmobciNQtyMuevg4UUZoik\n" +
			"SvTD3w43MU0cMJVJYDINTxI6AeDPkTYokgSE8ReDYQR/erIOjHTBX4ABDwhO8jcp4Qx/fBE6MeIP\n" +
			"TEF4xDQxvOHvneB/EI74E7KvIBx/rAol/OYvRcImowveoQOhIRQDiQXb8VclT0FUkCkQRLBmisAy\n" +
			"kAUMLNBA+T9TkD9gIhRnTgxoBCURBNGJYFuCU5DM/yk4gMX4iLD8ATDIxV++vv/mGKExzku0f1T8\n" +
			"YTiezoaSJHE8kQNkFhjiiBgSxPJPCI1UcEQYyPyzigYnjKKZNElsw4FAHxAwAg/hIPLPIAqkQ8I5\n" +
			"oKAwSERmjOICQZB0ENs/CLxAShEK+BPCHHJE9lg8LvThzz+7+UNBEVMQ4E8sraSQDxybiOBPA+0E\n" +
			"koE/fhTSgzL+wCAQPf4QQMgH/pRRChP+BGEKOP7QI9EgHPRA0CX+aPHBPwIA0wEk/4AzxD9S+FPB\n" +
			"PwP4E8Y/j2hByT/IYCnnGP40MaIHKmTzTz5mqQNJAID984Q/Fyj3lxzKVSJMDP6AEsk/SPiDi3YX\n" +
			"Zf9Cgz/8CKSKP9X8Mwwg/+QhgT8I/LOAPwX848cK/2BSjj8J/EOJPxa0Ep8/8njqzwLrRQOZG/9s\n" +
			"4I8h/+yxhD84DHQGGf6o8U8Py/ijT0aF+pMFq7zZMcIxAjXiTw7/NODPD5FYENhzkMWgyQT+ICFQ\n" +
			"Af4w8E8F/myhnQ7+IPuYP6j8k4I/6WAl0Cz+oCNQCf5IQEhGjFz7xz88+HOCK7QIRMgX/pTwjwb+\n" +
			"4MNDsSOS4A8Q/4jiDzl3CIRFFP+kImUlC0J2wD+++GMMnif4I8NAbEB2NSZAVCznRWe8IPU/v5Di\n" +
			"z58CPdAPZE78AhkKBIEBGTcP+8OFQAj4w4vG/uD/IdAr/hhBI2Rv/EOnPwMMtI4/1gikBmTdZERy\n" +
			"mv+8sa1ALqwAmRT/kNzFUv+UokYd/tyiCRse6C3QDyP84wzOVxcBmbr6ZiAQZez4IBAFkLmGgBWo\n" +
			"zZNRGtdaeooWlUERwQpgKFluJJA1Ew0dKYjCaS//QIKpECEsUkMc/5jhzwSWauPPF+7g548NBzSh\n" +
			"BKglRMJIKJAFgAMAENfQ0kXzbC7QNSnzhyxCYYJ/LAsbydIFZDIAABGNawYC2QFkaKCAYvzjDEoS\n" +
			"hEDc4A8yCCRH//KECXCRKg0s4h8wgEwFIsEwtF0kUP5IxUByIYNnEMEJApFbIgRiiSDAwROqaYc/\n" +
			"/64wECcoAg2KGAgHSlALS/3jATlIBw95wYx6CAQVnqDGqv6RCzog40UgUAIJMJIHyPBgIYVAxIsM\n" +
			"UgrINCAic9gERdzwBmdYpAfwWF8pKJKN9ozhMwr5GkUEkIAGbIgikKgEEqYByM88oDsWcUZVGknJ\n" +
			"SlrykpjMSiEIQQgocCAGLDjAJjZhADc44JSoPMQhCkALT7jylbCMJS8YwIASlIABvIilLl/ZADrY\n" +
			"wR6HQCUq0SLKN2xiHnG4xzxisL+DZGMPiRiAAwzggCNSAAV84AMKEtAGDHjzmxgYAQD68YlymvOc\n" +
			"5zRCOTyghBOowAuuMAI651lOcgZgBOD0Zih4kGgAM/ChCU2ggBp2gQADnGIA2oiBHb3zgEK0oAWd\n" +
			"EEch4lAEH+TCB4Uogi1cwNGOclQSIA2pSEcqCQiw4R5zmMM85lBSkroUpGzwqEyLUAgf2JQDcWiB\n" +
			"E4LxgBZoIjeZDKpQh0rUotYkIAA7\n" +
			"\n" +
			"--asdfAErweSDFRwe234sf_q765ASDdweewhKUTR--\n" +
			"\n" +
			"--URFNfBE4vb9UxaPOU9e_bBkq1WiwQroju3XgnN--";
	
	private String multipartContent2 ="--URFNfBE4vb9UxaPOU9e_bBkq1WiwQroju3XgnN\n"+
			"Content-Disposition: form-data; name=\"root-fields\"\n"+
			"Content-Transfer-Encoding: 8bit\n"+
			"\n"+
			"{\"a\":\"b\"}\n"+
			"\n"+
			"--URFNfBE4vb9UxaPOU9e_bBkq1WiwQroju3XgnN\n"+
			"Content-Disposition: form-data; name=\"attachments\"\n"+
			"Content-Type: multipart/mixed; boundary=asdfAErweSDFRwe234sf_q765ASDdweewhKUTR\n"+
			"\n";
	
	@Test
	public void test(){
		try{
			MultipartPart part=new MultipartPart(multipartContent.getBytes(contentEncoding),contentEncoding);
			String contentType=part.getContentHeader("Content-Type");
			Assert.assertEquals(contentType, "application/xml");
			
			part=new MultipartPart(multipartContent2.getBytes(contentEncoding),contentEncoding);
			contentType=part.getContentHeader("Content-Type");
			Assert.assertEquals(contentType, "application/json");
		}catch (Exception ex){
			fail(ex.getMessage());
			ex.printStackTrace();
		}
		
	}

}
