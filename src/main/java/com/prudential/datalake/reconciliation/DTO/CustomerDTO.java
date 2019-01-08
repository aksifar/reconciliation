package com.prudential.datalake.reconciliation.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.prudential.datalake.reconciliation.model.BEXTPF;
import com.prudential.datalake.reconciliation.model.CHDRPF;
import com.prudential.datalake.reconciliation.model.CLADPF;
import com.prudential.datalake.reconciliation.model.CLBAPF;
import com.prudential.datalake.reconciliation.model.CLDPPF;
import com.prudential.datalake.reconciliation.model.CLEXPF;
import com.prudential.datalake.reconciliation.model.CLMHPF;
import com.prudential.datalake.reconciliation.model.CLNTPF;
import com.prudential.datalake.reconciliation.model.LIFEPF;
import com.prudential.datalake.reconciliation.model.LINSPF;
import com.prudential.datalake.reconciliation.model.RTRNPF;
import com.prudential.datalake.reconciliation.model.UWQSPF;
import com.prudential.datalake.reconciliation.model.transformed.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class CustomerDTO {
	private String id;
	private Customer customer;
	private CLNTPF clntpf;
	private CLDPPF cldppf;
	private CHDRPF chdrpf;
	private UWQSPF uwqspf; 
	
	private CLEXPF clexpf;
	private CLBAPF clbapf;
	private BEXTPF bextpf;
	private RTRNPF rtrnpf;
	private LINSPF linspf;
	private LIFEPF lifepf;
	private CLADPF cladpf;
	private CLMHPF clmhpf;
}
