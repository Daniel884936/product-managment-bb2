package com.productmanagment.productmanagment.DTOAssemblers.productAssembler;

import com.productmanagment.productmanagment.DTOAssemblers.DTOAssemblerFactory.HibernateDTOAssemblerFactory;
import com.productmanagment.productmanagment.configs.ProductConf;
import com.productmanagment.productmanagment.dtos.ProductDTO;
import com.productmanagment.productmanagment.dtos.ProductReductionPriceDTO;
import com.productmanagment.productmanagment.dtos.SupplierDTO;
import com.productmanagment.productmanagment.models.Product;
import com.productmanagment.productmanagment.models.ProductReductionPrice;
import com.productmanagment.productmanagment.models.Supplier;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

// TODO Delete circular referenceS
public class ProductAssemblerHibernate implements  ProductAssembler{

    @Override
    public Product Dto2Pojo(ProductDTO productDTO) {
        if(productDTO== null){
            return  null;
        }

        Product result = new Product();

        BeanUtils.copyProperties(productDTO, result);
        if(result.getProductId()!= null && result.getProductId() == 0){
            result.setProductId(null);
        }

        //Ser productCause
        if(productDTO.getProductCause()!= null){
            result.setProductCause(HibernateDTOAssemblerFactory.DEFAULT.getProductCauseAssembler().dto2Pojo(productDTO.getProductCause()));
        }

        //Set product reduction prices
        List<ProductReductionPriceDTO> productReductionPriceDTOS  = productDTO.getProductReductionPrices();
        if(productReductionPriceDTOS!= null){
            result.setProductReductionPrices(new ArrayList<>());
            productReductionPriceDTOS.forEach(productReductionPriceDTO -> {
                //TODO
                result.addProductReductionPrice(HibernateDTOAssemblerFactory.DEFAULT.getProductReductionPriceAssembler().dtoToPojo(productReductionPriceDTO));
            });
        }
        if(productReductionPriceDTOS == null){
            result.setProductReductionPrices(null);
        }

        //Set supplier
        List<SupplierDTO> supplierDTOS = productDTO.getSuppliers();
        if(supplierDTOS != null){
            result.setSuppliers(new ArrayList<>());
            supplierDTOS.forEach(supplierDTO -> {
                //TODO
                result.addSupplier(HibernateDTOAssemblerFactory.DEFAULT.getSupplierAssembler().Dto2Pojo(supplierDTO));
            });
        }
        if(supplierDTOS == null){
            result.setSuppliers(null);
        }
        return result;
    }

    @Override
    public ProductDTO pojo2Dto(Product product, ProductConf productConf) {
        if(product == null){
            return null;
        }

        ProductDTO result = new ProductDTO();
        BeanUtils.copyProperties( product, result);

        if(result.getProductId() != null && result.getProductId() == 0){
            result.setProductId(null);
        }

        //Set productCause
        if(product.getProductCause() != null){
            result.setProductCause(HibernateDTOAssemblerFactory.DEFAULT.getProductCauseAssembler().pojo2Dto(product.getProductCause()));
        }

        //Set product reduction prices
        List<ProductReductionPrice> productReductionPrices = product.getProductReductionPrices();
        if(productReductionPrices != null){
            result.setProductReductionPrices(new ArrayList<>());
            productReductionPrices.forEach(productReductionPrice -> {
                //TODO
                result.addProductReductionPrice(HibernateDTOAssemblerFactory.DEFAULT.getProductReductionPriceAssembler().pojo2Dto(productReductionPrice));
            });
        }

        //Set supplier
        if(productConf.getSuppliersConf()!=null){
            List<Supplier> suppliers = product.getSuppliers();
            if(suppliers != null){
                result.setSuppliers(new ArrayList<>());
                suppliers.forEach(supplier -> {
                    //TODO
                    result.addSupplier(HibernateDTOAssemblerFactory.DEFAULT.getSupplierAssembler().pojo2Dto(supplier, productConf.getSuppliersConf().getConf()));
                });
            }
            if(suppliers == null){
                result.setSuppliers(null);
            }
        }
        if (product.getCreator() != null) {
            if(product.getCreator().getUserId() != null){
                result.setUserId(product.getCreator().getUserId());
            }
        }
        return result;
    }

}
