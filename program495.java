import java.io.*;
import java.util.*;

class program495
{
    public static void main(String Arg[])
    {
        String PackName = null;
        Scanner sobj = null;
        
        try
        {
            sobj = new Scanner(System.in);

            System.out.println("---------------------------------------------------------------------");
            System.out.println("-------------- Marvellous Packer Unpacker CUI Module ----------------");
            System.out.println("---------------------------------------------------------------------");
            

            System.out.println("---------------------------- Unpacking Activity -----------------------");

            System.out.println("Enter the name of packed file that you want to unpack : ");
            PackName = sobj.nextLine();
            
            File fobj = new File(PackName);

            if(fobj.exists())
            {
                FileInputStream fiobj = new FileInputStream(fobj);

                byte Header[] = new byte[100];

                fiobj.read(Header);

                String SHeader = new String(Header);
                SHeader = SHeader.trim();
                String Arr[] = SHeader.split(" ");

                File fobjX = new File(Arr[0]);
                fobjX.createNewFile();

                FileOutputStream foobj = new FileOutputStream(fobjX);

                int FileSize = Integer.parseInt(Arr[1]);
                byte Buffer[] = new byte[FileSize];

                fiobj.read(Buffer);
                foobj.write(Buffer,0,FileSize);

                foobj.close();
                fiobj.close();
            }
            else
            {
                System.out.println("There is no such packed file");
                return;
            }

            System.out.println("---------------------------------------------------------------------");
            System.out.println("--------- Thank you for using Marvellous Packer-Unpacker ------------");
            System.out.println("---------------------------------------------------------------------");

        } // End of try
        catch(Exception eobj)
        {
            System.out.println("Exception occured : "+eobj);
        }
    }
}