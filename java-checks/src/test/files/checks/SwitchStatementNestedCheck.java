class A{
  void foo() {
    int myVar = 0;
    switch (myVar) {  // Compliant
      case 0:
        switch (0) {  // Noncompliant
          case 0:
          case 1:
            System.out.println();
            switch (1){ // Noncompliant [[sc=13;ec=19;el=+0]] {{Refactor the code to eliminate this nested "switch".}}
              case 0:
              case 1:
                break;
            }
          case 2:
            break;
        }
      case 1:
        switch (2) { // Noncompliant
          case 0:
          case 1: 
            switch (3){ // Noncompliant {{Refactor the code to eliminate this nested "switch".}}
              case 0: 
                System.out.println();
              case 1:
                break;
            }
            break;
          case 2: 
            break;
        }
        break;
      case 2: 
        break;
      default:
        switch(4) {  // Noncompliant
          case 0:
            switch(5) { // Noncompliant
              default:
                break;
            } 
            break;
        }
    }
  }
}

class B{
  
  void foo2() {
    int i = 0;
    switch(i) {  // Compliant
      case 1:
        break;
    }
  }
  
}
 