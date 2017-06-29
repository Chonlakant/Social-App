package com.app.sample.social.model;

import java.util.List;

/**
 * Created by Bas on 6/28/2017 AD.
 */

public class PostProduct {

    private int status;
    private ProductBean product;
    private String href;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ProductBean getProduct() {
        return product;
    }

    public void setProduct(ProductBean product) {
        this.product = product;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public static class ProductBean {
        /**
         * id : 64
         * user_id : 164
         * name : ข้าวพื้นเมือง
         * description : เป็นข้าวสารพันธุ์หายาก
         * category : 1
         * price : 95
         * location : สุรินทร์
         * status : 0
         * type : 0
         * time : 1498627754
         * active : 1
         * images : [{"id":"80","image":"https://www.zaab-d.com/upload/photos/2017/06/NtT2iv9oHr5tL9M69ypW_28_db84ee3a412c1dcc0b60bfd372b67077_image.jpg","product_id":"64","image_org":"https://www.zaab-d.com/upload/photos/2017/06/NtT2iv9oHr5tL9M69ypW_28_db84ee3a412c1dcc0b60bfd372b67077_image_small.jpg"}]
         * time_text : 0 seconds
         * post_id : 1920
         * edit_description : เป็นข้าวสารพันธุ์หายาก
         * url : https://www.zaab-d.com/post/1920
         */

        private String id;
        private String user_id;
        private String name;
        private String description;
        private String category;
        private String price;
        private String location;
        private String status;
        private String type;
        private String time;
        private String active;
        private String time_text;
        private String post_id;
        private String edit_description;
        private String url;
        private List<ImagesBean> images;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getActive() {
            return active;
        }

        public void setActive(String active) {
            this.active = active;
        }

        public String getTime_text() {
            return time_text;
        }

        public void setTime_text(String time_text) {
            this.time_text = time_text;
        }

        public String getPost_id() {
            return post_id;
        }

        public void setPost_id(String post_id) {
            this.post_id = post_id;
        }

        public String getEdit_description() {
            return edit_description;
        }

        public void setEdit_description(String edit_description) {
            this.edit_description = edit_description;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<ImagesBean> getImages() {
            return images;
        }

        public void setImages(List<ImagesBean> images) {
            this.images = images;
        }

        public static class ImagesBean {
            /**
             * id : 80
             * image : https://www.zaab-d.com/upload/photos/2017/06/NtT2iv9oHr5tL9M69ypW_28_db84ee3a412c1dcc0b60bfd372b67077_image.jpg
             * product_id : 64
             * image_org : https://www.zaab-d.com/upload/photos/2017/06/NtT2iv9oHr5tL9M69ypW_28_db84ee3a412c1dcc0b60bfd372b67077_image_small.jpg
             */

            private String id;
            private String image;
            private String product_id;
            private String image_org;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getProduct_id() {
                return product_id;
            }

            public void setProduct_id(String product_id) {
                this.product_id = product_id;
            }

            public String getImage_org() {
                return image_org;
            }

            public void setImage_org(String image_org) {
                this.image_org = image_org;
            }
        }
    }
}
