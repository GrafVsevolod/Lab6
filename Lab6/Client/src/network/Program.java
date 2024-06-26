package network;



import exceptions.WrongArgumentException;
import generators.IdGenerator;
import generators.OrganizationInput;
import models.Organization;

import java.util.Scanner;

public class Program {
    private static final int port = 2448;
    private static final int reconnectionTimeout = 5000;
    private static final int maxReconnectionAttempts = 5;
    public void execute() throws InterruptedException, WrongArgumentException {
        String[] input;
        Scanner scanner = new Scanner(System.in);
        Client client = new Client("localhost", port, reconnectionTimeout, maxReconnectionAttempts);
        System.out.println("Введите help для вывода справки по командам: ");
        while (true) {
            String cmd = (scanner.nextLine() + " ").trim();
            input = cmd.split(" ");
            if (input[0].equals("add") || input[0].equals("add_if_min")) {
                Organization organization = OrganizationInput.createOrganization(IdGenerator.generateID());
                System.out.println(client.sendRequest(new Request(organization, input)).getResult());
            }else if(input[0].equals("exit")){
                System.out.println("\n" +
                        "                               #include/*\n" +
                        "                            $r='$c=~s/putchar\n" +
                        "                          /pri';$c=q%#[*/<stdio.h>                  /*-]*/\n" +
                        "                        char*O=\"   +++ +[>++++++++<-]             +++   +++\\\n" +
                        "                    ++++>[  >+>   ++   +<<  -]>>+   +++          +++ [>   +>\\\n" +
                        "               +<<-]>>        <<<<         <..        >>.      ...  ...    .<\\\n" +
                        "           +++[>+   +++         ++++  <-]    >+    +>  >>+.  +++  +++    ++ +\\\n" +
                        "        +++..        ---         -.<   <<.-   ---   --   -----  ..[<   +>>  +<\\\n" +
                        "      -]>              >>   ++   +++     .<    .>   ..<             <-.>     >\\\n" +
                        "    ---    ---.+++      .<   .<   <<     .<.   ..   \";  int/*            >+[ >]\n" +
                        "  [*/    main   (){     int   R,   G,    N[   8],    U;   for  (U=     00;U  <8\n" +
                        " ;N[     U++    ]=0      ){   }for(      U=G    =U   -U     ;O  [R  =G++  ]; ){\n" +
                        " if      (O[   R]==      43   ){++N[U     ];}    else{       if (O[   R]==60 ){\n" +
                        "--        U;}else        {{  ;}     if(    91    ==    O    [R]  ){if(N[     U]\n" +
                        "==                      0){ for      (;   O[    G]-    93;  G++        ){;}G++;\n" +
                        "}}      else{if         (+O [R      ]==  45     ){N     [U]  --;    }else{  if\n" +
                        "(O[R]==62){U++;}        else{R     =G    -1;     if     (O   [R   ]==46     ){\n" +
                        " putchar(N[U]);        }else {    if(    O[R     ]==   93)   {            for\n" +
                        "  (G--;O[G]-          91;   --    G){     }}}     }}    }}      }}return-0;}\n" +
                        "   #/*               (c)   */    line      04    /*>           UG    UU\n" +
                        "      srand         +0;       %;($r       .='   nt+    chr /;$c=~s/\n" +
                        "         ([A-U])   /\\$                   $1          /g;$c=~s/char\\\n" +
                        "              s*\\*\\$O\\s*=/                  \\@O=unpack\"C*\",/;$c=~s\n" +
                        "                      !int/[^/]+/!sub!;')=~s/[\\n    ]//g;eval$r;\n" +
                        "                           eval\"$c;main();\";             #]*/");
                System.exit(1);
            }
            else{
                System.out.println(client.sendRequest(new Request(input)).getResult());
            }
        }
    }
}
