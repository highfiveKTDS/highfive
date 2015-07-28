package com.ktds.shoppingbell;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.ktds.shoppingbell.define.SelectedOptionItem;
import com.ktds.shoppingbell.define.SelectedShoppingMallItem;

public class RegistBellProductFragment extends Fragment {
    boolean isFirstAction = true;   //최초 첫번째 시작인지 판별하는 boolean 변수
    boolean isOptionCheck = false;
    boolean isPriceCheck = false;

    private Button btnRegistBell;

    private CheckBox chkPrice;
    private CheckBox chkOption;

    private EditText etPrice;
    private EditText etModel;

    private Spinner spinnerShoppingmall_list;
    private Spinner spinnerOption_list;
    private Spinner spinnerSize_list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View registBellProductView = setInitComponent(inflater, container);
        return registBellProductView;
    }

    private View setInitComponent(LayoutInflater inflater, ViewGroup container) {
        View registBellProductView
                = inflater.inflate(R.layout.fragment_regist_bell_product
                , container
                , false);


        btnRegistBell = (Button) registBellProductView.findViewById(R.id.btnRegistBell);


        chkPrice  = (CheckBox) registBellProductView.findViewById(R.id.chkPrice);
        chkOption = (CheckBox) registBellProductView.findViewById(R.id.chkOption);

        etPrice = (EditText) registBellProductView.findViewById(R.id.etPrice);
        etModel = (EditText) registBellProductView.findViewById(R.id.etModel);

        spinnerShoppingmall_list = (Spinner) registBellProductView.findViewById(R.id.spinnerShoppingMallList);
        spinnerOption_list       = (Spinner) registBellProductView.findViewById(R.id.spinnerOptionList);
        spinnerSize_list         = (Spinner) registBellProductView.findViewById(R.id.spinnerSizeList);

        //필요 없는 컴포넌트 숨기기.
        etPrice.setVisibility(View.GONE);
        spinnerOption_list.setVisibility(View.GONE);
        spinnerSize_list.setVisibility(View.GONE);

        setEventListener(registBellProductView); //버튼, Spinner등등 클릭 이벤트 기능이 있음

        return registBellProductView;
    }

    private void setEventListener(View view) {
        chkPrice.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isPriceCheck = !isPriceCheck;
                if (isFirstAction) {
                    isFirstAction = !isFirstAction;
                    etPrice.setVisibility(View.VISIBLE);
                    return;
                }
                if (isChecked) {
                    etPrice.setVisibility(View.VISIBLE);
                } else {
                    etPrice.setVisibility(View.GONE);
                    etPrice.setText("");
                }
            }
        });

        chkOption.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isOptionCheck = !isOptionCheck;
                if (isChecked) {
                    spinnerOption_list.setVisibility(View.VISIBLE);

                } else {
                    spinnerSize_list.setSelection(0);   //아이템 0번째로 초기화([사이즈를 선택하세요])
                    spinnerOption_list.setSelection(0); //아이템 0번째로 초기화([쇼핑몰을 선택하세요])

                    spinnerOption_list.setVisibility(View.GONE);
                    spinnerSize_list.setVisibility(View.GONE);
                }
            }
        });

        spinnerOption_list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == SelectedOptionItem.ITEM_SIZE) {
                    spinnerSize_list.setVisibility(View.VISIBLE);
                } else {
                    spinnerSize_list.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        btnRegistBell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Validation Check
                if (etModel.getText().toString().equals("")) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(v.getContext());
                    alert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();     //닫기
                        }
                    });
                    alert.setMessage("모델명을 적어주세요!");
                    alert.show();

                    return;
                }

                if (spinnerShoppingmall_list.getSelectedItemPosition() == 0) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(v.getContext());
                    alert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();     //닫기
                        }
                    });
                    alert.setMessage("쇼핑몰을 선택하세요!");
                    alert.show();

                    return;
                }
                String size = "";
                Log.d("CHK:", spinnerSize_list.getSelectedItem().toString());

                if (isOptionCheck) {
                    if (spinnerOption_list.getSelectedItemPosition() == SelectedOptionItem.EMPTY_ITEM) {
                        AlertDialog.Builder alert = new AlertDialog.Builder(v.getContext());
                        alert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();     //닫기
                            }
                        });
                        alert.setMessage("옵션을 선택하세요!");
                        alert.show();
                        return;
                    }

                    if (spinnerSize_list.getSelectedItemPosition() == 0) {
                        AlertDialog.Builder alert = new AlertDialog.Builder(v.getContext());
                        alert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();     //닫기
                            }
                        });
                        alert.setMessage("사이즈를 선택하세요!");
                        alert.show();
                        return;
                    }
                    size = spinnerSize_list.getSelectedItem().toString();
                } else {
                    size = "empty";
                }

                if(isPriceCheck) {
                    if(etPrice.getText().toString().equals("")) {
                        AlertDialog.Builder alert = new AlertDialog.Builder(v.getContext());
                        alert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();     //닫기
                            }
                        });
                        alert.setMessage("가격을 입력하세요!");
                        alert.show();
                        return;
                    }

                }

                String model = etModel.getText().toString();
                String price = etPrice.getText().toString();


                String mall = "";

                if (spinnerShoppingmall_list.getSelectedItemPosition() == SelectedShoppingMallItem.ITEM_AUCTION) {
                    mall = "옥션";
                }
                if (spinnerShoppingmall_list.getSelectedItemPosition() == SelectedShoppingMallItem.ITEM_11STREET) {
                    mall = "11번가";
                }

                if (spinnerShoppingmall_list.getSelectedItemPosition() == SelectedShoppingMallItem.ITEM_SHOPPINGBELL) {
                    mall = "쇼핑벨 중고장터";
                }

                Toast.makeText(v.getContext()
                        , model + "/" + price + "/" + mall + "/" + size
                        , Toast.LENGTH_SHORT).show();

                //FIXME: 쇼핑벨을 신청하는 기능 추가
            }
        });
    }
}
