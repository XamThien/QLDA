package main.java.model;

import java.util.ArrayList;

import main.java.model.*;

public class SessionMuonSach extends MuonTra {
	private static final long serialVersionUID = 1L;
	private  ArrayList<ChiTietMuonTra> items;
    
    public SessionMuonSach() {
       
        items = new ArrayList<>();
        
    }
    
    public ArrayList<ChiTietMuonTra> getItems(){
        return items;
    }
    
    
    public void addItem(ChiTietMuonTra item){
        int index = isDuplicate(item);
        
        if(index !=-1){
        	ChiTietMuonTra tmp = items.get(index);
            items.get(index).setSoLuong(tmp.getSoLuong() + item.getSoLuong());
        }else{
            items.add(item);
        }
    }
    public int isDuplicate(ChiTietMuonTra sp){
        for(int i=0; i<items.size();i++){
			if(items.get(i).getSach().getId()==sp.getSach().getId()){
				return i;
			}
		}
	return -1;
    }
    public int isDuplicateMa(int x){
        for(int i=0; i<items.size();i++){
			if(items.get(i).getId()==x){
				return i;
			}
		}
	return -1;
    }
    public void remove(ChiTietMuonTra item){
        if(this.items !=null){
            items.remove(item);
        }
    }
    public void update(int mahh,int sl){
        
        for(int i=0; i<items.size();i++){
			if(items.get(i).getSach().getId()==mahh){
				items.get(i).setSoLuong(sl);
			}
		}
    }
    public ChiTietMuonTra getItem(int mahh){
        for(int i=0; i<items.size();i++){
			if(items.get(i).getSach().getId()==mahh){
				return items.get(i);
			}
		}
        return null;
    }
}
