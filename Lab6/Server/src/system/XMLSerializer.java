package system;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;
import models.Address;
import models.Coordinates;
import models.Organization;
import models.OrganizationType;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.LinkedList;

public class XMLSerializer {
    public XStream xstream;

    public XMLSerializer(){
        xstream = new XStream(new StaxDriver());
        xstream.alias("address", Address.class);
        xstream.alias("coordinates", Coordinates.class);
        xstream.alias("organization", Organization.class);
        xstream.alias("organizationType", OrganizationType.class);
        xstream.setMode(XStream.NO_REFERENCES);
        xstream.addPermission(AnyTypePermission.ANY);
        xstream.allowTypeHierarchy(ArrayDeque.class);
        xstream.allowTypeHierarchy(String.class);
        xstream.ignoreUnknownElements();
    }

    public String serialize(LinkedList<Organization> data) {
        String rawData = xstream.toXML(data);
        return rawData;
    }
    public LinkedList<Organization> deserialize(String path) {
        xstream.setMode(XStream.NO_REFERENCES);
        xstream.addPermission(NoTypePermission.NONE);
        xstream.addPermission(NullPermission.NULL);
        xstream.addPermission(PrimitiveTypePermission.PRIMITIVES);
        xstream.allowTypeHierarchy(LinkedList.class);
        xstream.allowTypeHierarchy(String.class);
        xstream.ignoreUnknownElements();
        xstream.allowTypes(new Class[] {LinkedList.class, Organization.class});

        LinkedList <Organization> data = new LinkedList<>();
        try (BufferedInputStream bInputStream = new BufferedInputStream(new FileInputStream("/Users/admin/Library/CloudStorage/OneDrive-ITMOUNIVERSITY/Lab6 Server/src/lab.xml"))) {
            byte[] bytes = bInputStream.readAllBytes();
            bInputStream.close();
            String rawData  = new String(bytes);
            data = (LinkedList<Organization>) xstream.fromXML(rawData);
        }
        catch (FileNotFoundException e){
            System.out.println("Файл не найден");
        }
        catch (IOException e){
            System.out.println("Ошибка ввода");
        }
        return data;
    }
}
