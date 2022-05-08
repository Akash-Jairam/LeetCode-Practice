class FileSystem {
    Directory root;
    
    public FileSystem() {
       this.root = new Directory("/"); 
    }
    
    public List<String> ls(String path) {
        path = path.substring(1);
        String[] parsedPath = path.split("/");
        Directory it = root;
        for(String p : parsedPath){
            if(it.children.containsKey(p)){
                it = it.children.get(p);
            }
        }
        
        List<String> list = new ArrayList<>();
        if(it.name.equals(parsedPath[parsedPath.length-1]) || (parsedPath.length == 1 && parsedPath[0].equals(""))){
            for(File f : it.files.values()){
                list.add(f.name);
            }
            
            for(String d : it.children.keySet()){
                list.add(d);
            }
            Collections.sort(list);
        } else{
            String file = parsedPath[parsedPath.length-1];
            if(it.files.containsKey(file)){
                list.add(file);
            }
        }
        return list;
    }
    
    public void mkdir(String path) {
        path = path.substring(1);
        String[] parsedPath = path.split("/");
        Directory it = root;
        for(String p : parsedPath){
            if(!it.children.containsKey(p)){
                it.children.put(p, new Directory(p));
            }
            it = it.children.get(p);
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        filePath = filePath.substring(1);
        String[] parsedPath = filePath.split("/");
        String file = parsedPath[parsedPath.length-1];
        Directory it = root;
        for(String p : parsedPath){
            if(it.children.containsKey(p))
                it = it.children.get(p);
        }
        
        if(it.files.containsKey(file)){
            it.files.get(file).addContent(content);
        } else{
            it.files.put(file, new File(content, file));
        }
    }
    
    public String readContentFromFile(String filePath) {
        filePath = filePath.substring(1);
        String[] parsedPath = filePath.split("/");
        String file = parsedPath[parsedPath.length-1];
        Directory it = root;
        for(String p : parsedPath){
            if(it.children.containsKey(p))
                it = it.children.get(p);
        }
        return it.files.get(file).getContent();
    }
}

class Directory{
    String name;
    HashMap<String, File> files;
    HashMap<String, Directory> children;
    
    public Directory(String name){
        this.name = name;
        this.files = new HashMap<>();
        this.children = new HashMap<>();
    }
}

class File{
    String content;
    String name;
    
    public File(String content, String name){
        this.content = content;
        this.name = name;
    }
    
    public String getContent(){
        return this.content;
    }
    
    public void addContent(String content){
        this.content = this.content + "" + content;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */