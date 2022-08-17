package comuser.shop.jinproject.inter;


import comuser.shop.jinproject.model.network.Header;

public interface CRUDInterFace<Req,Res> {

    Header<Res> create(Header<Req> request);  //todo request object 추가

    Header<Res> read(int id);

    Header<Res> update(Header<Req>  request);

    Header<Res> delete(int id);
}
