namespace=z_q
registry=registry.cn-hangzhou.aliyuncs.com

function build () {
    cd $1
    sh ./build.sh
}

cmds=( \

build_eureka \
build_config \
build_api_gateway \
build_product \
build_order \
build_user

)

function do_command () {

    case $1 in

        build_order)
            build order
            ;;

        build_api_gateway)
            build api-gateway
            ;;

        build_eureka)
            build eureka
            ;;
            
        build_config)
            build config
            ;;

        build_product)
            build product
            ;;

        build_user)
            build user
            ;;

        *)

            echo "Please select what you want to do:"

            ;;

    esac

}



# functional codes for this shell, you can ignore

function select_cmd () {

    echo "Please select what you want to do:"

    select CMD in ${cmds[*]}; do

        if [[  $(in_array $CMD ${cmds[*]}) = 0 ]]; then

            do_command $CMD

            break

        fi

    done

}

function select_arg () {

    cmd=$1

    shift 1

    options=("$@")



    echo "Please select which arg you want:"

    select ARG in ${options[*]}; do

        if [[  $(in_array ${ARG} ${options[*]}) = 0 ]]; then

            ${cmd} ${ARG}

            break

        fi

    done

}

function in_array () {

    TARGET=$1

    shift 1

    for ELEMENT in $*; do

        if [[ "$TARGET" == "$ELEMENT" ]]; then

            echo 0

            return 0

        fi

    done

    echo 1

    return 1
}

function main () {
    if [[ $1 != "" && $(in_array $1 ${cmds[*]}) = 0 ]]; then
        do_command $*
    else
        select_cmd
    fi
}

main $*