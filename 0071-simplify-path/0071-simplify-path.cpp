class Solution {
public:
    void dequeAppend(deque<string> &dirs, string dir) {
        if(dir.empty() || dir == ".") return;
        if(dir == "..") {
            if(!dirs.empty()) dirs.pop_back();
        }
        else dirs.push_back(dir);
    }
    
    string simplifyPath(string path) {
        string res = "/";
        deque<string> dirs;
        string dir = "";
        for(int i = 0; i < path.size(); i++) {
            if(path[i] == '/') {
                dequeAppend(dirs, dir);
                dir = "";
            } else {
                dir += path[i];
                if(i == path.size()-1) dequeAppend(dirs,dir);
            } 
        }
        int i = 0;
        for(auto dir: dirs) {
            res += dir;
            if(i != dirs.size()-1)
                res += "/";
            i++;
        }
        return  res;
    }
};