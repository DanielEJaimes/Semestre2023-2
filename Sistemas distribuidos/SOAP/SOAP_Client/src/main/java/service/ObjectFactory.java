
package service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SearchName_QNAME = new QName("http://service/", "searchName");
    private final static QName _SearchArtist_QNAME = new QName("http://service/", "searchArtist");
    private final static QName _SearchGender_QNAME = new QName("http://service/", "searchGender");
    private final static QName _SearchNameResponse_QNAME = new QName("http://service/", "searchNameResponse");
    private final static QName _SearchGenderResponse_QNAME = new QName("http://service/", "searchGenderResponse");
    private final static QName _SearchArtistResponse_QNAME = new QName("http://service/", "searchArtistResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SearchNameResponse }
     * 
     */
    public SearchNameResponse createSearchNameResponse() {
        return new SearchNameResponse();
    }

    /**
     * Create an instance of {@link SearchGender }
     * 
     */
    public SearchGender createSearchGender() {
        return new SearchGender();
    }

    /**
     * Create an instance of {@link SearchArtist }
     * 
     */
    public SearchArtist createSearchArtist() {
        return new SearchArtist();
    }

    /**
     * Create an instance of {@link SearchName }
     * 
     */
    public SearchName createSearchName() {
        return new SearchName();
    }

    /**
     * Create an instance of {@link SearchArtistResponse }
     * 
     */
    public SearchArtistResponse createSearchArtistResponse() {
        return new SearchArtistResponse();
    }

    /**
     * Create an instance of {@link SearchGenderResponse }
     * 
     */
    public SearchGenderResponse createSearchGenderResponse() {
        return new SearchGenderResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "searchName")
    public JAXBElement<SearchName> createSearchName(SearchName value) {
        return new JAXBElement<SearchName>(_SearchName_QNAME, SearchName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchArtist }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "searchArtist")
    public JAXBElement<SearchArtist> createSearchArtist(SearchArtist value) {
        return new JAXBElement<SearchArtist>(_SearchArtist_QNAME, SearchArtist.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchGender }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "searchGender")
    public JAXBElement<SearchGender> createSearchGender(SearchGender value) {
        return new JAXBElement<SearchGender>(_SearchGender_QNAME, SearchGender.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "searchNameResponse")
    public JAXBElement<SearchNameResponse> createSearchNameResponse(SearchNameResponse value) {
        return new JAXBElement<SearchNameResponse>(_SearchNameResponse_QNAME, SearchNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchGenderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "searchGenderResponse")
    public JAXBElement<SearchGenderResponse> createSearchGenderResponse(SearchGenderResponse value) {
        return new JAXBElement<SearchGenderResponse>(_SearchGenderResponse_QNAME, SearchGenderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchArtistResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "searchArtistResponse")
    public JAXBElement<SearchArtistResponse> createSearchArtistResponse(SearchArtistResponse value) {
        return new JAXBElement<SearchArtistResponse>(_SearchArtistResponse_QNAME, SearchArtistResponse.class, null, value);
    }

}
