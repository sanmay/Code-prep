
class GraphTest{

    public static void main(String[] args){
        GraphManager G=new GraphManager(5,10);
        G.insert(1,3,1);
        G.insert(1,2,2);
        G.insert(2,3,5);
        G.print();
        G.MST();
    }
}